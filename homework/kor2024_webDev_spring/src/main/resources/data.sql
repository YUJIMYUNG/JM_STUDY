-- 회원테이블 샘플
insert into member (mid, mpwd, mphone) VALUES ("qwer", "123123", "010-1111-2222");
insert into member (mid, mpwd, mphone) VALUES ("asdf", "456456", "010-3333-4444");
insert into member (mid, mpwd, mphone) VALUES ("zxcv", "789789", "010-5555-6666");

-- 카테고리테이블 샘플
insert into category (cname) values ("채소");
insert into category (cname) values ("견과류");
insert into category (cname) values ("쌀");
insert into category (cname) values ("수산건어물");
insert into category (cname) values ("정육");

-- 상품 샘풀
insert into product (pname, pprice, pstock, cno) values ("쭈꾸미볶음2종", "4000", "30", 4);
insert into product (pname, pprice, pstock, cno) values ("갈비탕", "10000", "30", 5);
insert into product (pname, pprice, pstock, cno) values ("떡갈비", "8000", "30", 5);
insert into product (pname, pprice, pstock, cno) values ("청양고추", "2000", "30", 1);
insert into product (pname, pprice, pstock, cno) values ("양파", "1500", "30", 1);
insert into product (pname, pprice, pstock, cno) values ("잡곡", "8000", "30", 3);
insert into product (pname, pprice, pstock, cno) values ("아몬드", "5000", "30", 2);
insert into product (pname, pprice, pstock, cno) values ("삼계탕", "12000", "30", 5);
insert into product (pname, pprice, pstock, cno) values ("호두", "2000", "30", 2);

-- 주문 샘풀
insert into orders (ostate, mno, pno, cdate, udate) values ("0", 1, 2, now(), now());

insert into orders (ostate, mno, pno, cdate, udate) values ("0", 1, 1, now(), now());

insert into orders (ostate, mno, pno, cdate, udate) values ("0", 2, 3, now(), now());

insert into orders (ostate, mno, pno, cdate, udate) values ("0", 2, 4, now(), now());

insert into orders (ostate, mno, pno, cdate, udate) values ("0", 3, 5, now(), now());