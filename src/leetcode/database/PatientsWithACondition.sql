# 1527. Patients With a Condition
select patient_id, patient_name, conditions
from Patients
where left(conditions, 5) = 'DIAB1'
union
select patient_id, patient_name, conditions
from Patients
where conditions like '% DIAB1%'
