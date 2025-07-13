# 3586. Find COVID Recovery Patients
with t1 as (select patient_id,
                   min(test_date) first_positive_date
            from covid_tests
            where result = 'Positive'
            group by patient_id),
     t2 as (select t.patient_id, min(t.test_date) first_negative_date
            from covid_tests t,
                 t1
            where t.patient_id = t1.patient_id
              and t.result = 'Negative'
              and t.test_date > t1.first_positive_date
            group by t.patient_id)
select t.patient_id,
       t.patient_name,
       t.age,
       datediff(first_negative_date, first_positive_date) recovery_time
from patients t,
     t1,
     t2
where t.patient_id = t1.patient_id
  and t1.patient_id = t2.patient_id
order by recovery_time, t.patient_name
