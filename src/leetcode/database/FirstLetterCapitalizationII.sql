# 3374. First Letter Capitalization II
/*
create function transform(content_text text)
    returns text
begin
    declare len int default 1;
    declare curr_char char default "";
    declare prev_char char default "";
    declare converted_text text default "";
    while len < length(content_text)
        do
            set curr_char = right(left(content_text, len), 1);
            if regexp_like(curr_char, '^[a-z]$') or regexp_like(curr_char, '^[A-Z]$') then
                if len = 1 then
                    set converted_text = concat(converted_text, upper(curr_char));
                else
                    set prev_char = right(left(content_text, len - 1), 1);
                    if !regexp_like(prev_char, '^[a-z]$') and !regexp_like(prev_char, '^[A-Z]$') then
                        set converted_text = concat(converted_text, upper(curr_char));
                    else
                        set converted_text = concat(converted_text, lower(curr_char));
                    end if;
                end if;
            else
                set converted_text = concat(converted_text, curr_char);
            end if;
            set len = len + 1;
        end while;
    return converted_text;
end;
*/
select content_id,
       content_text                           original_text,
       replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(
                                                                                                                       replace(
                                                                                                                               replace(
                                                                                                                                       replace(
                                                                                                                                               replace(
                                                                                                                                                       replace(
                                                                                                                                                               replace(
                                                                                                                                                                       replace(
                                                                                                                                                                               replace(
                                                                                                                                                                                       replace(
                                                                                                                                                                                               replace(
                                                                                                                                                                                                       replace(
                                                                                                                                                                                                               replace(
                                                                                                                                                                                                                       regexp_replace(
                                                                                                                                                                                                                               concat(
                                                                                                                                                                                                                                       upper(left(content_text, 1)),
                                                                                                                                                                                                                                       lower(substr(content_text, 2))),
                                                                                                                                                                                                                               '([^a-z])([a-z])',
                                                                                                                                                                                                                               '$0~'),
                                                                                                                                                                                                                       'a~',
                                                                                                                                                                                                                       'A'),
                                                                                                                                                                                                               'b~',
                                                                                                                                                                                                               'B'),
                                                                                                                                                                                                       'c~',
                                                                                                                                                                                                       'C'),
                                                                                                                                                                                               'd~',
                                                                                                                                                                                               'D'),
                                                                                                                                                                                       'e~',
                                                                                                                                                                                       'E'),
                                                                                                                                                                               'f~',
                                                                                                                                                                               'F'),
                                                                                                                                                                       'g~',
                                                                                                                                                                       'G'),
                                                                                                                                                               'h~',
                                                                                                                                                               'H'),
                                                                                                                                                       'i~',
                                                                                                                                                       'I'),
                                                                                                                                               'j~',
                                                                                                                                               'J'),
                                                                                                                                       'k~',
                                                                                                                                       'K'),
                                                                                                                               'l~',
                                                                                                                               'L'),
                                                                                                                       'm~',
                                                                                                                       'M'),
                                                                                                               'n~',
                                                                                                               'N'),
                                                                                                       'o~', 'O'),
                                                                                               'p~', 'P'),
                                                                                       'q~', 'Q'), 'r~', 'R'),
                                                                       's~', 'S'), 't~', 'T'), 'u~',
                                                       'U'), 'v~', 'V'), 'w~', 'W'), 'x~', 'X'),
                       'y~', 'Y'), 'z~', 'Z') converted_text
from user_content;