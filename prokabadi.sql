
create  database  prokabadi;
use  prokabadi;
create  table  Team(team_id  int  AUTO_INCREMENT  PRIMARY  KEY,team_name  varchar(50),team_zone  char);
create  table  match_schedule(match_id  int  primary  key,match_time  DATETIME);
insert  into  team(team_name,team_zone)values("Vellore",'A');
insert  into  team(team_name,team_zone)values("Chennai",'A');
insert  into  team(team_name,team_zone)values("Kanchi",'A');
insert  into  team(team_name,team_zone)values("Krishnagiri",'A');
insert  into  team(team_name,team_zone)values("Thiruvannamalai",'A');
insert  into  team(team_name,team_zone)values("Villupuram",'A');
insert  into  team(team_name,team_zone)values("Perambalur",'B');
insert  into  team(team_name,team_zone)values("Karaikudi",'B');
insert  into  team(team_name,team_zone)values("Tiruchi",'B');
insert  into  team(team_name,team_zone)values("Madurai",'B');
insert  into  team(team_name,team_zone)values("Kovai",'B');
insert  into  team(team_name,team_zone)values("Kanyakumari",'B');
insert  into  match_schedule  (team1,team2,match_time)values(1,2,'2017-08-05  13:00:00');
insert  into  match_schedule  (team1,team2,match_time)values(3,4,'2017-08-05  15:00:00');
insert  into  match_schedule  (team1,team2,match_time)values(5,6,'2017-08-06  13:00:00');
insert  into  match_schedule  (team1,team2,match_time)values(1,3,'2017-08-06  15:00:00');
insert  into  match_schedule  (team1,team2,match_time)values(2,4,'2017-08-07  13:00:00');
update    match_schedule  set  team1=6  where  match_id=4;
insert  into  match_schedule  (team1,team2,match_time)values(5,1,'2017-08-07  15:00:00');
alter  table  match_schedule  add  column  match_zone  char;
update  match_schedule  set  match_zone='A';
create  table  match_outcome(match_id  int  primary  key,match_status  char,team1_score  int,team2_score  int,win_team  int,foreign  key  (match_id)  references  match_schedule(match_id),foreign  key  (win_team)  references  Team(team_id));
insert  into  match_outcome  values(1,'W',30,27,1);
insert  into  match_outcome  values(2,'W',28,29,4);
insert  into  match_outcome  values(4,'W',25,19,3);
insert  into  match_outcome  values(5,'W',25,27,2);
insert  into  match_outcome  values(6,'W',27,25,1);
alter table match_outcome add column lose_team int,add constraint foreign key (lose_team) references team(team_id);
update match_outcome set lose_team=2 where match_id=1;
update match_outcome set lose_team=3 where match_id=2;
update match_outcome set lose_team=6 where match_id=4;
update match_outcome set lose_team=4 where match_id=5;
update match_outcome set lose_team=5 where match_id=6;
insert  into  match_schedule  (team1,team2,match_time)values(3,6,'2017-08-09  13:00:00');
insert  into  match_outcome  values(7,'W',27,25,3);
insert  into  match_outcome  values(7,'W',27,25,3,6);
select  team1,team2  from  match_schedule  where  team1=1  or  team2=1;
select  *  from  match_outcome;
select  *  from  match_schedule;
select  team.team_name  from  team  inner  join  match_schedule  on  match_schedule.team1=team.team_id  or  match_schedule.team2=team.team_id;
select  team.team_name  from  team  inner  join  match_schedule  on  match_schedule.team1=team.team_id  or  match_schedule.team2=team.team_id  where  match_schedule.team1=1  or  match_schedule.team2=1;
select team.team_id,team.team_name,count(match_outcome.win_team) as wins from team left join match_outcome on team.team_id=match_outcome.win_team group by team_id;
select team.team_id,team.team_name,count(*) as win  from team inner join match_schedule on (match_schedule.team1 = team.team_id or match_schedule.team2=team.team_id)  group by team.team_id;