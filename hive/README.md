### 第一题 展示电影ID为2116这部电影各年龄段的平均影评分

#### sql语句：
select u.age,avg(r.rate) as

from hive_sql_test1.t_rating r 

left join hive_sql_test1.t_user u on r.userid = u.userid

where r.movieid = 2166

group by u.age;

运行结果:![第一题](https://github.com/jwwc/bigdata/blob/main/hive/image/one.png)

### 第二题 找出男性评分最高且评分次数超过50次的10部电影，展示电影名，平均影评分和评分次数

#### sql语句：

SELECT m.moviename,avg(r.rate) as avgrate, count(r.movieid) as total

from hive_sql_test1.t_rating as r

LEFT JOIN hive_sql_test1.t_user as u on r.userid = u.userid

LEFT JOIN hive_sql_test1.t_movie as m on m.movieid = r.movieid

WHERE u.sex = 'M'

GROUP BY m.movieid,m.moviename

HAVING count(r.movieid) > 50

ORDER BY avgrate DESC LIMIT 10

运行结果![第二题](https://github.com/jwwc/bigdata/blob/main/hive/image/two.png)
