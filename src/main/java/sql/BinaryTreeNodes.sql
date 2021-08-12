select concat(N, " ",
              case
                  when P is null then 'Root'
                  when N In (select distinct P from bst) then 'Inner'
                  else 'Leaf'
                  end
           )
from bst
order by N;