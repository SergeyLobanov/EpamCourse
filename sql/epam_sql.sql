#1. Написать запрос, считающий суммарное количество имеющихся на сайте новостей и обзоров.

select count(*) from 
	(select * from news 
    union 
    select * from reviews) tbl


#2. Написать запрос, показывающий список категорий новостей и количество новостей в каждой категории.

select nc_name, count(n_id)
	from news_categories nc left join news n  
	on nc.nc_id = n.n_category
    group by nc_name


#3. Написать запрос, показывающий список категорий обзоров и количество обзоров в каждой категории.

select rc_name, count(r_id)
	from reviews_categories rc left join reviews r  
	on rc.rc_id = r.r_category
    group by rc_name


#4. Написать запрос, показывающий список категорий новостей, категорий обзоров и 
#   дату самой свежей публикации в каждой категории.

select nc_name category_name, max(n_dt) last_date
	from news n join news_categories nc 
	on nc.nc_id = n.n_category
    group by nc_name
union
select rc_name category_name, max(r_dt) last_date
	from reviews r join reviews_categories rc 
	on rc.rc_id = r.r_category
    group by rc_name

# 5. Написать запрос, показывающий список страниц сайта верхнего уровня 
# (у таких страниц нет родительской страницы) и список баннеров для каждой такой страницы.

select p_name, b.b_id, b_url
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    where p.p_parent is null
	
#6. Написать запрос, показывающий список страниц сайта, на которых есть баннеры.

select p_name
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    group by p_name
    
#7. Написать запрос, показывающий список страниц сайта, на которых нет баннеров.

select p_name
	from pages p left join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    where m2m.b_id is null
    group by p_name
    
#8. Написать запрос, показывающий список баннеров, размещённых хотя бы на одной странице сайта.

select b.b_id, b_url
	from banners b join m2m_banners_pages m2m
    on b.b_id = m2m.b_id
	group by b.b_id
    
#9. Написать запрос, показывающий список баннеров, не размещённых ни на одной странице сайта.

select b.b_id, b_url
	from banners b left join m2m_banners_pages m2m
    on b.b_id = m2m.b_id
    where m2m.p_id is null
    

# 10. Написать запрос, показывающий баннеры, для которых отношение 
# кликов к показам >= 80% (при условии, что баннер был показан хотя бы один раз).

select b.b_id, b_url, b.b_click/b.b_show rate
	from banners b 
    where b.b_click/b.b_show >= 0.8 and b.b_show > 0
    group by b.b_id

# 11. Написать запрос, показывающий список страниц сайта, на которых 
# показаны баннеры с текстом (в поле `b_text` не NULL).

select p_name 
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    where b.b_text is not null
    group by p_name
    
# 12. Написать запрос, показывающий список страниц сайта, на которых 
# показаны баннеры с картинкой (в поле `b_pic` не NULL).

select p_name 
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    where b.b_pic is not null
    group by p_name

#13. Написать запрос, показывающий список публикаций (новостей и обзоров) за 2011-й год.

select n_header header, n_dt date
	from news
    where YEAR(n_dt) = 2011
union
select r_header header, r_dt date
	from reviews
    where YEAR(r_dt) = 2011

#14. Написать запрос, показывающий список категорий публикаций (новостей и обзоров), в которых нет публикаций.

select nc_name category
	from news_categories nc left join news n 
    on n.n_category = nc.nc_id
    where n.n_category is null
    group by nc_name
union
select rc_name category
	from reviews_categories rc left join reviews r 
    on  r.r_category = rc.rc_id
    where r.r_category is null 
    group by rc_name

# 15. Написать запрос, показывающий список новостей из категории «Логистика» за 2012-й год.

select n_header, n_dt
	from news n join news_categories nc
    on n.n_category = nc.nc_id
    where nc_name = "Логистика" and year(n_dt) = 2012

#16. Написать запрос, показывающий список годов, за которые есть новости, а также количество новостей за каждый из годов.

select year(n_dt) year, count(*) 
	from news n join news_categories nc
    on n.n_category = nc.nc_id
    group by year(n_dt)
    
# 17. Написать запрос, показывающий URL и id таких баннеров, где для одного и того же URL есть несколько баннеров.

select b_url, b_id
	from banners b
    where 1 < (select count(*)
				from banners b1
                where b.b_url = b1.b_url)
                
# 18. Написать запрос, показывающий список непосредственных 
# подстраниц страницы «Юридическим лицам» со списком баннеров этих подстраниц.

select p_name, b.b_id, b_url
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id join banners b
    on m2m.b_id = b.b_id
    where p.p_parent = 1
    
# 19. Написать запрос, показывающий список всех баннеров с 
# картинками (поле `b_pic` не NULL), отсортированный по убыванию отношения кликов по баннеру к показам баннера.

select b_id, b_url, b_click/b_show rate
	from banners
    where b_pic is not null
    order by b_click/b_show
    
#20. Написать запрос, показывающий самую старую публикацию на сайте (не важно – новость это или обзор).

select header, date
	from 
	(select n_header header, n_dt date
		from news   
	union
	select r_header header, r_dt date
		from reviews) oldest
	order by date
	limit 1
    
#21. Написать запрос, показывающий список баннеров, URL которых встречается в таблице один раз.

select b_url, b_id
	from banners b
    where 1 = (select count(*)
				from banners b1
                where b.b_url = b1.b_url)
    
# 22. Написать запрос, показывающий список страниц сайта в 
# порядке убывания количества баннеров, расположенных на странице. 
# Для случаев, когда на нескольких страницах расположено одинаковое 
# количество баннеров, этот список страниц должен быть отсортирован по возрастанию имён страниц.

select p_name, count(b.b_id) banners_count
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    group by p_name
    order by count(b.b_id) desc, p_name
    
# 23. Написать запрос, показывающий самую «свежую» новость и самый «свежий» обзор.

select n_header header, max(n_dt) date
	from news_categories nc join news n
    on nc.nc_id = n.n_category
union
select r_header header, max(r_dt) date
	from reviews_categories rc join reviews r
    on rc.rc_id = r.r_category
    
# 24. Написать запрос, показывающий баннеры, в тексте которых встречается часть URL, 
# на который ссылается баннер.

select b_id, b_url, b_text
	from banners b
    where locate(b_text, b_url)


# 25. Написать запрос, показывающий страницу, на которой размещён баннер 
# с самым высоким отношением кликов к показам.

# other result, few pages with 150% rate
select p_name 
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    where b.b_click/b.b_show = (select max(b.b_click/b.b_show)
										from pages p join m2m_banners_pages m2m
										on p.p_id = m2m.p_id
										join banners b
										on m2m.b_id = b.b_id)

#26. Написать запрос, считающий среднее отношение кликов 
#к показам по всем баннерам, которые были показаны хотя бы один раз.

select avg(b.b_click/b.b_show)
	from banners b
    #where b.b_show != 0

# 27. Написать запрос, считающий среднее отношение кликов 
# к показам по баннерам, у которых нет графической части (поле `b_pic` равно NULL).

select avg(b.b_click/b.b_show)
	from banners b
    where b.b_pic is null

# 28. Написать запрос, показывающий количество баннеров, 
# размещённых на страницах сайта верхнего уровня (у таких страниц нет родительских страниц).

select count(*)
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    where p.p_parent is null
    
# 29. Написать запрос, показывающий баннер(ы), который(ые) показаны 
# на самом большом количестве страниц.

select b.b_id, b_url, count(*)
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    group by b.b_id
    having count(*) = (select max(count)
						from (select count(*) count
								from pages p join m2m_banners_pages m2m
								on p.p_id = m2m.p_id
								join banners b
								on m2m.b_id = b.b_id
								group by b.b_id) tbl)

# 30. Написать запрос, показывающий страницу(ы), на которой(ых) показано больше всего баннеров.

select p_name, count(*)
	from pages p join m2m_banners_pages m2m
    on p.p_id = m2m.p_id
    join banners b
    on m2m.b_id = b.b_id
    group by p_name
    having count(*) = (select max(count)
						from (select count(*) count
								from pages p join m2m_banners_pages m2m
								on p.p_id = m2m.p_id
								join banners b
								on m2m.b_id = b.b_id
								group by p_name) tbl)
                                
