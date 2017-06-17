use awtennis;
select * from aw_user;
update aw_user set sex=1 where aw_user.id=5;

select 
aw_activity.*,
aw_arena.name as arena_name
from aw_activity,aw_arena
where aw_activity.arenaId=aw_arena.id;

select aw_activity.*,aw_arena.name arena_name from aw_activity left join aw_arena on aw_activity.arenaId=aw_arena.id WHERE aw_activity.name like "%周六%";


select aw_activity.*,aw_arena.name arena_name from aw_activity left join aw_arena on aw_activity.arenaId=aw_arena.id 
WHERE aw_activity.startedAt between "2017-05-24 15:36:30" and "2017-05-24 15:36:30";

insert into aw_arena(name,address,type,indoorNumber,outdoorNumber) values
('华师大塑胶场地','普陀区金沙江路145号',1,0,7);

insert into aw_activity(name,arenaId,detail,cost,startedAt,endedAt) values
('周二拉球活动',1,'群拉球活动',35,now(),now()),
('周三拉球活动',1,'群拉球活动',42,now(),now());

truncate table aw_activity;
truncate table aw_arena;

alter table aw_activity change `arena` `arenaId` int;

alter table aw_arena change `type` `type` int;

alter table aw_tournament change `arena` `arenaId` int;

select * from aw_team;

select * from aw_arena where type=0;

delete from aw_arena where id=3;

select now();

alter table aw_tournament change `prize` `prize` int;
select * from aw_tournament where id=1;

insert into aw_team(user1Id,user2Id,entry,startedAt) values
(1,2,6,now());

select *,(select name from aw_user as user1 where user1.id=aw_team.user1Id) as user1_name,(select name from aw_user as user2 where user2.id=aw_team.user2Id) as user2_name
from aw_team;

select aw_team.*,user1.name as user1_name,user2.name as user2_name from aw_team,aw_user as user1,aw_user as user2 where aw_team.user1Id=user1.id and aw_team.user2Id=user2.id;

select aw_team.*,user1.name as user1_name,user2.name as user2_name 
from aw_team 
join aw_user as user1 on aw_team.user1Id=user1.id
join aw_user as user2 on aw_team.user2Id=user2.id;

select 
aw_tournament.*,
aw_arena.name as arena_name,
aw_pointrule.*
from aw_tournament
left join aw_pointrule on aw_tournament.id=aw_pointrule.tournamentId 
left join aw_arena on aw_tournament.arenaId=aw_arena.id;

select aw_tournament.*,aw_arena.name as 'arena_name' 
from aw_tournament left join aw_arena on aw_tournament.arenaId=aw_arena.id;

truncate aw_pointrule;

alter table aw_singlematch change `outcome` `outcome` char(1);
alter table aw_doublematch change `outcome` `outcome` char(1);
alter table aw_singlematch change `winnerPoint` `HCPoint` int not null comment '主场选手积分';
alter table aw_singlematch change `loserPoint` `APPoint` int not null comment '客场选手积分';
alter table aw_singlematch add `HCRetired` bool default'0' not null comment '主场选手退赛';
alter table aw_singlematch add `APRetired` bool default'0' not null comment '客场选手退赛';
alter table aw_doublematch change `winnerPoint` `HCPoint` int not null comment '主场选手积分';
alter table aw_doublematch change `loserPoint` `APPoint` int not null comment '客场选手积分';
alter table aw_doublematch add `HCRetired` bool default'0' not null comment '主场选手退赛';
alter table aw_doublematch add `APRetired` bool default'0' not null comment '客场选手退赛';
alter table aw_user add `grade` varchar(10) comment '组别(如金组)';

alter table aw_singlematch add `isHCChallenger` bool default'0' not null comment '主场选手为挑战者';
alter table aw_singlematch add `isAPChallenger` bool default'0' not null comment '客场选手为挑战者';
alter table aw_doublematch add `isHCChallenger` bool default'0' not null comment '主场选手为挑战者';
alter table aw_doublematch add `isAPChallenger` bool default'0' not null comment '客场选手为挑战者';

alter table aw_team add `name` varchar(10) not null comment'组合名称(默认为选手名称)';

alter table aw_teampoint change `point` `points` int comment '当周所获积分';

select
aw_singlematch.*,
aw_singlematchscore.matchId,
aw_singlematchscore.setTH,
aw_singlematchscore.HCScore,
aw_singlematchscore.HCTieScore,
aw_singlematchscore.APScore,
aw_singlematchscore.APTieScore,
aw_arena.name as arena_name,
aw_tournament.name as tournament_name,
user1.name as user1_name,
user2.name as user2_name
from aw_singlematch
join aw_arena on aw_singlematch.matchPlace=aw_arena.id
join aw_tournament on aw_singlematch.tournamentId=aw_tournament.id
join aw_user as user1 on aw_singlematch.homeContestant=user1.id
join aw_user as user2 on aw_singlematch.awayPlayer=user2.id
join aw_singlematchscore on aw_singlematch.id=aw_singlematchscore.matchId;

truncate table aw_singlematch;
delete from aw_singlematch where id=1;

select * from aw_singlematch;
select aw_singlematch.*,aw_singlematchscore.* from aw_singlematch,aw_singlematchscore where aw_singlematch.id=aw_singlematchscore.matchId;

select * from aw_singlematchscore;

select aw_individualpoint.*,aw_user.name as user_name
from aw_individualpoint
left join aw_user on aw_user.id=aw_individualpoint.userId;

/*禁用外键约束*/
SET FOREIGN_KEY_CHECKS=0;

select 
aw_doublematch.*,
aw_doublematchscore.matchId,
aw_doublematchscore.setTH,
aw_doublematchscore.HCScore,
aw_doublematchscore.HCTieScore,
aw_doublematchscore.APScore,
aw_doublematchscore.APTieScore,
aw_arena.name as arena_name,
aw_tournament.name as tournament_name,
hcteam.name as hcteam_name,
apteam.name as apteam_name,
hcteam_user1.name as hcteam_user1_name,
hcteam_user2.name as hcteam_user2_name,
apteam_user1.name as apteam_user1_name,
apteam_user2.name as apteam_user2_name
from aw_doublematch
join aw_doublematchscore on aw_doublematch.id=aw_doublematchscore.matchId
join aw_arena on aw_doublematch.matchPlace=aw_arena.id
join aw_tournament on aw_doublematch.tournamentId=aw_tournament.id
join aw_team as hcteam on aw_doublematch.homeContestant=hcteam.id
join aw_team as apteam on aw_doublematch.awayPlayer=apteam.id
join aw_user as hcteam_user1 on hcteam.user1Id=hcteam_user1.id
join aw_user as hcteam_user2 on hcteam.user2Id=hcteam_user2.id
join aw_user as apteam_user1 on apteam.user1Id=apteam_user1.id
join aw_user as apteam_user2 on apteam.user2Id=apteam_user2.id
where hcteam.name like "%蛐蛐%";

select * from aw_doublematchscore where matchId=1;

select 
aw_teampoint.*,
aw_team.name as team_name
from aw_teampoint
join aw_team on aw_team.id=aw_teampoint.teamId
where year=2012;


select 
aw_punishment.*,
aw_user.name as user_name,
aw_tournament.name as tournament_name
from aw_punishment
join aw_user on aw_punishment.userId=aw_user.id
join aw_tournament on aw_punishment.tournamentId=aw_tournament.id
where userId=1 and entry=1;