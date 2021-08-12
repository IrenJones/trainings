CREATE FUNCTION simpleFunc(name varchar(50)) RETURNS DECIMAL(9,2)
BEGIN
  DECLARE res varchar(60);
  SET res = concat('aaaaaaaaaa', name);
  RETURN res;
END