select concat(name, '(', substr(occupation, 1, 1), ')') as fm
from OCCUPATIONS
order by name;

select concat('There are a total of ', count(occupation), ' ', lower(occupation), 's.') as cnt
from occupations
group by occupation
order by cnt asc;