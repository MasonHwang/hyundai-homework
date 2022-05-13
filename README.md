# hyundai-homework

# 테이블 구조
```sql
create table board (
    bno number,
    btitle varchar2(200) not null,
    bcontent varchar2(4000) not null,
    bdate timestamp not null,
    mid varchar2(20) not null,
    bhitcount number not null,
    iid varchar2(100)
);

alter table board add constraint pk_board primary key(bno);
alter table board add constraint fk_board_member foreign key(mid) references member (mid);
alter table board add constraint fk_board_image foreign key(iid) references image(iid);

create sequence seq_board;

create table image (
    iid varchar2(100),
    iattachoname varchar2(100),
    iattachsname varchar2(100)
);
alter table image add constraint pk_image primary key(iid);
```
