SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- -----------------------------------------------------
-- Table person
-- -----------------------------------------------------
CREATE  TABLE person (
 person_id INT NOT NULL ,
 name VARCHAR(25) NULL ,
 street_no VARCHAR(25) NULL ,
 street_name VARCHAR(25) NULL ,
 city VARCHAR(25) NULL ,
 person_state VARCHAR(25) NULL ,
 zip_code VARCHAR(25) NULL ,
 email VARCHAR(25) NULL ,
 gender VARCHAR(25) NULL ,
  PRIMARY KEY (person_id) )
;

INSERT INTO person 
 VALUES('10001','john','35','no','waldo','la','70122','john12@gmail.com','M');
 
  INSERT INTO person
 VALUES('10002','mike','123','br','main','la','87342','mineping@gmail.com','M');
 
 INSERT INTO person
 VALUES('10003','ria','786','ny','clear view','ny','19887','riany@live.com','F');
 
 INSERT INTO person
 VALUES('10004','peter','535','la','river side','ca','87654','petermanning@yahoo.com','M');
 
 INSERT INTO person
 VALUES('10005','pia','786','ny','view','ny','19857','pianyc@live.com','F');
 
 INSERT INTO person
 VALUES('10006','manning','315','la','park side','ca','88649','manning@yahoo.com','M');
 
 INSERT INTO person
 VALUES('10007','mike','15','dallas','founders','tx','62549','setnning@yahoo.com','M');
 
 INSERT INTO person
 VALUES('10008','steve','908','sf','long beach','ca','89765','steve2go@gmail.com','M');
 
 INSERT INTO person
 VALUES('10009','king','678','chicago','road side','il','32256','kingforall@gmail.com','F');
 
 INSERT INTO person
 VALUES('10010','kura','007','new orleans','warrington','la','83815','warrior4u@gmail.com','M');

-- -----------------------------------------------------
-- Table phone
-- -----------------------------------------------------
CREATE  TABLE phone (
 person_id INT NOT NULL ,
 phone_no BIGINT NOT NULL ,
  PRIMARY KEY (person_id,phone_no) ,
      FOREIGN KEY (person_id )
    REFERENCES person (person_id )
    )
;
INSERT INTO phone VALUES('10001','5789108367');
INSERT INTO phone VALUES('10002','3733883815');
INSERT INTO phone VALUES('10003','5042563705');
INSERT INTO phone VALUES('10003','5673843361');
INSERT INTO phone VALUES('10005','6784893810');
INSERT INTO phone VALUES('10006','5143683814');
INSERT INTO phone VALUES('10004','2174386817');
INSERT INTO phone VALUES('10008','5046684876');
INSERT INTO phone VALUES('10001','8900387315');
INSERT INTO phone VALUES('10010','5043883815');

-- -----------------------------------------------------
-- Table position
-- -----------------------------------------------------
CREATE  TABLE position (
 pos_code INT NOT NULL ,
 title VARCHAR(25) NULL ,
 pos_desc VARCHAR(25) NULL ,
  PRIMARY KEY (pos_code) )
;
INSERT INTO position VALUES('20001','Grad_Student','dfasdfkl');
INSERT INTO position VALUES('20002','Employee','pkadkhfk');
INSERT INTO position VALUES('20003','TA','dsfadf ddf vcv');
INSERT INTO position VALUES('20004','Instructor','dfadsfdfads adsfads');
INSERT INTO position VALUES('20005','Student_worker','y54yergwer rgrge g');
INSERT INTO position VALUES('20006','RA','1235rfa geryt5qgtr');

-- -----------------------------------------------------
-- Table knowledge_skill
-- -----------------------------------------------------
CREATE  TABLE knowledge_skill (
 ks_code INT NOT NULL ,
 title VARCHAR(25) NULL ,
 ks_desc VARCHAR(25) NULL ,
 ks_level VARCHAR(25) NULL ,
  PRIMARY KEY (ks_code) )
;
INSERT INTO knowledge_skill VALUES('30001','clanguage','J','fghjkl');
INSERT INTO knowledge_skill VALUES('30002','webtech','S','yh0iu');
INSERT INTO knowledge_skill VALUES('30003','database','A','t6gdfghlk');
INSERT INTO knowledge_skill VALUES('30004','.net','J','tf8p');
INSERT INTO knowledge_skill VALUES('30005','java','J','df9iu');
INSERT INTO knowledge_skill VALUES('30006','c++','S','frg-o');
INSERT INTO knowledge_skill VALUES('30007','mysqldb','A','u-hpov');
INSERT INTO knowledge_skill VALUES('30008','php','J','oiug9i');
INSERT INTO knowledge_skill VALUES('30009','oracle','A','fgh-0oi');
INSERT INTO knowledge_skill VALUES('30010','html','J','fg0oicv');


-- -----------------------------------------------------
-- Table required_skill
-- -----------------------------------------------------
CREATE  TABLE required_skill (
 pos_code INT NOT NULL ,
 ks_code INT NOT NULL ,
  PRIMARY KEY (pos_code,ks_code) ,
      FOREIGN KEY (ks_code )
    REFERENCES knowledge_skill (ks_code )
    ,
    FOREIGN KEY (pos_code )
    REFERENCES position (pos_code )
    )
;
INSERT INTO required_skill VALUES('20001','30009');
INSERT INTO required_skill VALUES('20001','30006');
INSERT INTO required_skill VALUES('20001','30004');
INSERT INTO required_skill VALUES('20005','30001');
INSERT INTO required_skill VALUES('20004','30003');
INSERT INTO required_skill VALUES('20003','30005');
INSERT INTO required_skill VALUES('20004','30009');
INSERT INTO required_skill VALUES('20003','30008');
INSERT INTO required_skill VALUES('20006','30010');
INSERT INTO required_skill VALUES('20002','30002');



-- -----------------------------------------------------
-- Table job
-- -----------------------------------------------------
CREATE  TABLE job (
 job_code INT NOT NULL 
 job_type VARCHAR(25) NULL ,
 pay_rate INT NULL ,
 pay_type VARCHAR(25) NULL ,
 company VARCHAR(25) NULL ,
  PRIMARY KEY (job_code) )
;
INSERT INTO job VALUES('40001','full','12000','w','deloitte');
INSERT INTO job VALUES('40002','full','6000','w','infosys');
INSERT INTO job VALUES('40003','full','20000','w','jpmorgan');
INSERT INTO job VALUES('40004','part','3000','w','deloitte');
INSERT INTO job VALUES('40005','full','18000','w','deloitte');
INSERT INTO job VALUES('40006','full','24000','w','accenture');
INSERT INTO job VALUES('40007','part','2500','w','seetel');
INSERT INTO job VALUES('40008','part','9000','w','seetel');
INSERT INTO job VALUES('40009','full','16000','w','jpmorgan');
INSERT INTO job VALUES('40010','part','8000','w','jpmorgan');


-- -----------------------------------------------------
-- Table company
-- -----------------------------------------------------
CREATE  TABLE company (
 company_id INT NOT NULL ,
 company_name VARCHAR(25) NULL ,
 street_no VARCHAR(25) NULL ,
 street_name VARCHAR(25) NULL ,
 city VARCHAR(25) NULL ,
 zip_code VARCHAR(25) NULL ,
 website VARCHAR(25) NULL ,
 GSA BOOLEAN NOT NULL ,
  PRIMARY KEY (company_id) )
;
INSERT INTO company 
VALUES('50001','deloitte','1234','adubon','new orleans','70122','deloitte@soft.inc','1');
INSERT INTO company 
VALUES('50002','seetel','5678','adubon','new orleans','70122','seetel@technologies.com','1');
INSERT INTO company 
VALUES('50003','accenture','1234','31st ST','kenner','70234','accenture@soft.inc','1');
INSERT INTO company 
VALUES('50004','infosys','7890','cleary','new metairie','70002','infosys@softsol.in','0');
INSERT INTO company 
VALUES('50005','jpmorgan','2278','chateau dr','metairie','70002','jpmorgan@finance.com','0');

-- -----------------------------------------------------
-- Table speciality
-- -----------------------------------------------------
CREATE  TABLE speciality (
 speciality_name VARCHAR(25) NOT NULL ,
  PRIMARY KEY (speciality_name))
;
INSERT INTO speciality VALUES('construction');
INSERT INTO speciality VALUES('logistics service');
INSERT INTO speciality VALUES('computer hardware');
INSERT INTO speciality VALUES('software');
INSERT INTO speciality VALUES('electronics');
INSERT INTO speciality VALUES('basic materials');
INSERT INTO speciality VALUES('IT consulting');
INSERT INTO speciality VALUES('transportation');

-- -----------------------------------------------------
-- Table company_speciality
-- -----------------------------------------------------
CREATE  TABLE company_speciality (
 company_id INT NOT NULL ,
 speciality_name VARCHAR(25) NOT NULL ,
  PRIMARY KEY (company_id,speciality_name) ,
     FOREIGN KEY (company_id )
    REFERENCES company (company_id )
    ,
     FOREIGN KEY (speciality_name )
    REFERENCES speciality (speciality_name )
    )
;
INSERT INTO company_speciality VALUES('50001','construction');
INSERT INTO company_speciality VALUES('50002','logistics service');
INSERT INTO company_speciality VALUES('50004','computer hardware');
INSERT INTO company_speciality VALUES('50005','software');
INSERT INTO company_speciality VALUES('50001','electronics');
INSERT INTO company_speciality VALUES('50003','basic materials');
INSERT INTO company_speciality VALUES('50002','IT consulting');
INSERT INTO company_speciality VALUES('50005','transportation');
INSERT INTO company_speciality VALUES('50002','software');
INSERT INTO company_speciality VALUES('50004','software');

-- -----------------------------------------------------
-- Table project
-- -----------------------------------------------------
CREATE  TABLE project (
 proj_id INT NOT NULL ,
 title VARCHAR(25) NULL ,
 director VARCHAR(25) NULL ,
 budjet_code VARCHAR(25) NULL ,
 strart_date DATE NULL ,
 end_date DATE NULL ,
 company VARCHAR(25) NULL ,
  PRIMARY KEY (proj_id) )
;
INSERT INTO project VALUES('60001','project1','ahm','70001','11-may-11','12-may-30','deloitte');
INSERT INTO project VALUES('60002','project2','vyu','70006','05-dec-18','09-may-30','deloitte');
INSERT INTO project VALUES('60003','project3','ekr','70003','10-mar-24','10-nov-30','accenture');
INSERT INTO project VALUES('60004','project3','dki','70002','10-dec-12','12-may-31','seetel');
INSERT INTO project VALUES('60005','project4','svu','70002','03-nov-17','05-nov-02','seetel');
INSERT INTO project VALUES('60006','project5','lop','70004','05-may-05','09-mar-11','jpmorgan');
INSERT INTO project VALUES('60007','project4','awe','70009','11-may-01','11-may-28','jpmorgan');
INSERT INTO project VALUES('60008','project7','trs','70000','02-may-01','12-may-23','infosys');
INSERT INTO project VALUES('60009','project8','cvu','70025','07-mar-18','08-jul-26','infosys');
INSERT INTO project VALUES('60010','project9','sex','70232','11-may-01','12-may-30','jpmorgan');

-- -----------------------------------------------------
-- Table needs
-- -----------------------------------------------------
CREATE  TABLE needs (
 proj_id INT NOT NULL ,
 company_id INT NOT NULL ,
  PRIMARY KEY (proj_id,company_id) ,
     FOREIGN KEY (proj_id )
    REFERENCES project (proj_id )
    ,
      FOREIGN KEY (company_id )
    REFERENCES company (company_id )
    )
;
INSERT INTO needs VALUES('60010','50002');
INSERT INTO needs VALUES('60009','50001');
INSERT INTO needs VALUES('60007','50003');
INSERT INTO needs VALUES('60008','50001');
INSERT INTO needs VALUES('60006','50005');
INSERT INTO needs VALUES('60002','50001');
INSERT INTO needs VALUES('60004','50004');
INSERT INTO needs VALUES('60003','50002');
INSERT INTO needs VALUES('60002','50003');
INSERT INTO needs VALUES('60001','50004');

INSERT INTO needs VALUES('60010','50003');
INSERT INTO needs VALUES('60009','50004');
INSERT INTO needs VALUES('60007','50004');
INSERT INTO needs VALUES('60008','50009');
INSERT INTO needs VALUES('60006','50002');

INSERT INTO needs VALUES('60001','50002');
INSERT INTO needs VALUES('60009','50001');
INSERT INTO needs VALUES('60004','50003');
INSERT INTO needs VALUES('60008','50003');
INSERT INTO needs VALUES('60008','50005');


-- -----------------------------------------------------
-- Table p_ks
-- -----------------------------------------------------
CREATE  TABLE p_ks (
 person_id INT NOT NULL ,
 ks_code INT NOT NULL ,
  PRIMARY KEY (person_id,ks_code) ,
     FOREIGN KEY (person_id )
    REFERENCES person (person_id )
    ,
    FOREIGN KEY (ks_code )
    REFERENCES knowledge_skill (ks_code )
    )
;
INSERT INTO p_ks VALUES('10001','30003');
INSERT INTO p_ks VALUES('10001','30009');
INSERT INTO p_ks VALUES('10002','30007');
INSERT INTO p_ks VALUES('10004','30006');
INSERT INTO p_ks VALUES('10005','30004');
INSERT INTO p_ks VALUES('10007','30002');
INSERT INTO p_ks VALUES('10009','30001');
INSERT INTO p_ks VALUES('10010','30008');
INSERT INTO p_ks VALUES('10008','30002');
INSERT INTO p_ks VALUES('10010','30005');

INSERT INTO p_ks VALUES('10001','30002');
INSERT INTO p_ks VALUES('10001','30005');
INSERT INTO p_ks VALUES('10002','30008');
INSERT INTO p_ks VALUES('10004','30008');
INSERT INTO p_ks VALUES('10005','30001');
INSERT INTO p_ks VALUES('10007','30003');
INSERT INTO p_ks VALUES('10009','30006');
INSERT INTO p_ks VALUES('10010','30010');
INSERT INTO p_ks VALUES('10010','30006');
INSERT INTO p_ks VALUES('10008','30004');



-- -----------------------------------------------------
-- Table certificate
-- -----------------------------------------------------
CREATE  TABLE certificate (
 cer_code INT NOT NULL ,
 title VARCHAR(25) NULL ,
 cer_desc VARCHAR(25) NULL ,
 expire_date DATE NULL ,
 company_id INT NULL ,
 t_code INT NULL ,
  PRIMARY KEY (cer_code) ,
      FOREIGN KEY (company_id )
    REFERENCES company (company_id )
    )
;
INSERT INTO certificate VALUES ('80001','clanguage','hji','11-nov-01','50001','90001');
INSERT INTO certificate VALUES ('80002','c++','fgh','09-jul-19','50002','90002');
INSERT INTO certificate VALUES ('80003','java','dew','05-mar-16','50004','90003');
INSERT INTO certificate VALUES ('80004','webtech','sew','11-nov-24','50003','90004');
INSERT INTO certificate VALUES ('80005','database','fuck','2006-nov-04','50002','90001');
INSERT INTO certificate VALUES ('80007','oracle','saq','05-mar-01','50004','90005');
INSERT INTO certificate VALUES ('80008','php','uil','11-mar-08','50005','90006');
INSERT INTO certificate VALUES ('80006','sql','xzw','2004-mar-07','50001','90007');
INSERT INTO certificate VALUES ('80009','clanguage','pol','11-nov-21','50003','90008');
INSERT INTO certificate VALUES ('80010','java','utx','02-mar-16','50001','90009');


-- -----------------------------------------------------
-- Table tool
-- -----------------------------------------------------
CREATE  TABLE tool (
 t_code INT NOT NULL ,
 name VARCHAR(25) NULL ,
 tool_desc VARCHAR(25) NULL ,
 version INT NULL ,
 comapny_id INT NULL ,
  PRIMARY KEY (t_code) ,
      FOREIGN KEY (comapny_id )
    REFERENCES company (company_id )
    )
;
INSERT INTO tool VALUES ('90001','rockyz','cgt','10','50002');
INSERT INTO tool VALUES ('90002','shane warne','ert','11','50005');
INSERT INTO tool VALUES ('90008','hughes','wsa','12','50004');
INSERT INTO tool VALUES ('90005','taylor','cxz','13','50002');
INSERT INTO tool VALUES ('90004','wex','ytz','14','50001');
INSERT INTO tool VALUES ('90003','christy','kuf','15','50003');
INSERT INTO tool VALUES ('90007','kelaop','flap','16','50004');
INSERT INTO tool VALUES ('90006','ram','cox','17','50003');
INSERT INTO tool VALUES ('90009','sophia','zip','18','50001');
INSERT INTO tool VALUES ('90010','sara','tore','19','50005');

-- -----------------------------------------------------
-- Table course
-- -----------------------------------------------------
CREATE  TABLE course (
 c_code INT NOT NULL ,
 title VARCHAR(25) NULL ,
 course_level VARCHAR(25) NULL ,
 course_desc VARCHAR(25) NULL ,
 status VARCHAR(25) NULL ,
 retail_price FLOAT(25) NULL ,
  PRIMARY KEY (c_code) )
;
INSERT INTO course VALUES ('11001','Data Models','4125G','queries stmts','active','60.89');
INSERT INTO course VALUES ('11002','POS','4402G','exploits and vulnerabilities','active','26.82');
INSERT INTO course VALUES ('11003','Bio-Informatics','4315','c with bio-science','expired','34.67');
INSERT INTO course VALUES ('11004','computer security','4670G','security','active','46.78');
INSERT INTO course VALUES ('11005','computer vision','4460','matlab','expired','58');
INSERT INTO course VALUES ('11006','artifical intelligence','6232','sensor','active','89');
INSERT INTO course VALUES ('11007','concurrent programming','6257','java','expired','90.12');
INSERT INTO course VALUES ('11008','computational geometry','6891','c++','expired','43');
INSERT INTO course VALUES ('11009','abc','2567','alphabets','active','0');
INSERT INTO course VALUES ('11010','xyz','5678','thesis','active','100');


-- -----------------------------------------------------
-- Table job_pos
-- -----------------------------------------------------
CREATE  TABLE job_pos (
 pos_code INT NOT NULL ,
 job_code INT NOT NULL ,
  PRIMARY KEY (pos_code,job_code) ,
     FOREIGN KEY (pos_code )
    REFERENCES position (pos_code )
    ,
      FOREIGN KEY (job_code )
    REFERENCES job (job_code )
    )
;
INSERT INTO job_pos VALUES ('20001','40003');
INSERT INTO job_pos VALUES ('20005','40003');
INSERT INTO job_pos VALUES ('20001','40007');
INSERT INTO job_pos VALUES ('20002','40004');
INSERT INTO job_pos VALUES ('20005','40009');
INSERT INTO job_pos VALUES ('20003','40006');
INSERT INTO job_pos VALUES ('20006','40008');
INSERT INTO job_pos VALUES ('20003','40001');
INSERT INTO job_pos VALUES ('20004','40002');
INSERT INTO job_pos VALUES ('20001','40004');

INSERT INTO job_pos VALUES ('20005','40010');

INSERT INTO job_pos VALUES ('20006','40005');


-- -----------------------------------------------------
-- Table format
-- -----------------------------------------------------
CREATE  TABLE formats (
 format_type VARCHAR(20) NOT NULL ,
 c_code INT NOT NULL ,
  PRIMARY KEY (format_type,c_code) ,
        FOREIGN KEY (c_code )
    REFERENCES course (c_code )
    )
;
INSERT INTO formats VALUES('online','11001');
INSERT INTO formats VALUES('ct','11005');
INSERT INTO formats VALUES('online','11004');
INSERT INTO formats VALUES('online','11007');
INSERT INTO formats VALUES('online','11009');
INSERT INTO formats VALUES('ct','11002');
INSERT INTO formats VALUES('ct','11004');
INSERT INTO formats VALUES('online','11008');
INSERT INTO formats VALUES('ct','11003');
INSERT INTO formats VALUES('ct','11006');
INSERT INTO formats VALUES('ct','11010');

-- -----------------------------------------------------
-- Table session
-- -----------------------------------------------------
CREATE  TABLE sessions (
 session_Id INT NOT NULL ,
 c_code INT NULL ,
 start_date DATE NULL ,
 end_date DATE NULL ,
 session_format VARCHAR(25) NULL ,
 offered_by VARCHAR(25) NULL ,
 price FLOAT NULL ,
 status VARCHAR(25) NULL,
  PRIMARY KEY (session_Id) ,
    FOREIGN KEY (c_code )
    REFERENCES course (c_code )
    )
;
INSERT INTO sessions VALUES('12001','11004','11-may-01','12-may-30','classroom','yakiee','1900','active');
INSERT INTO sessions VALUES('12002','11005','2006-mar-01','09-nov-05','online','joe','1780','active');
INSERT INTO sessions VALUES('12003','11009','10-mar-24','10-nov-26','correspondance','musthafa','1225.67','expired');
INSERT INTO sessions VALUES('12006','11008','10-dec-12','12-nov-31','classroom','khan','1378.90','active');
INSERT INTO sessions VALUES('12004','11002','11-may-01','11-nov-19','classroom','alex','2567.25','active');
INSERT INTO sessions VALUES('12005','11007','2001-mar-14','08-dec-24','correspondance','alex','5621','expired');
INSERT INTO sessions VALUES('12007','11006','2000-mar-01','03-may-29','classroom','raaz','120.12','expired');
INSERT INTO sessions VALUES('12008','11008','2004-feb-01','2006-jul-14','online','phoenix','3131.56','active');
INSERT INTO sessions VALUES('12009','11003','05-may-03','11-dec-05','correspondance','angelina','1256.78','expired');
INSERT INTO sessions VALUES('12010','11001','11-nov-09','11-nov-30','online','joe','1900','active');


-- -----------------------------------------------------
-- Table learning_unit
-- -----------------------------------------------------
CREATE  TABLE learning_unit (
 lu_code INT NOT NULL AUTO_INCREMENT ,
 title VARCHAR(25) NULL ,
 topic VARCHAR(25) NULL ,
 lu_desc VARCHAR(100) NULL ,
 duration INT NULL ,
  PRIMARY KEY (lu_code) )
;
INSERT INTO learning_unit VALUES('13001','dbms','relational model','fki','120');
INSERT INTO learning_unit VALUES('13002','kernel exploits','kext','ear','180');
INSERT INTO learning_unit VALUES('13003','bioinformatices','codingwith"c"','side','100');
INSERT INTO learning_unit VALUES('13004','computersecure','tcp/ip','king','78');
INSERT INTO learning_unit VALUES('13005','computervisionary','optics','tres','35');
INSERT INTO learning_unit VALUES('13006','artifical intelligence','robotics','pre','42');
INSERT INTO learning_unit VALUES('13007','computation geometry','geometry','zunk','360');
INSERT INTO learning_unit VALUES('13008','concurrent program','all software languages','qual','234');
INSERT INTO learning_unit VALUES('13009','def','mno','mor','12');
INSERT INTO learning_unit VALUES('13010','ghi','uvw','hip','89');
-- -----------------------------------------------------
-- Table pre_req
-- -----------------------------------------------------
CREATE  TABLE pre_req (
 pre_req_id INT NOT NULL ,
 c_code INT NOT NULL ,
  PRIMARY KEY (pre_req_id,c_code) ,
     FOREIGN KEY (pre_req_id )
    REFERENCES course (c_code )
    ,
      FOREIGN KEY (c_code )
    REFERENCES course (c_code )
    ) ;

INSERT INTO pre_req VALUES('11001','11001');
INSERT INTO pre_req VALUES('11002','11002');
INSERT INTO pre_req VALUES('11003','11003');
INSERT INTO pre_req VALUES('11004','11004');
INSERT INTO pre_req VALUES('11005','11005');
INSERT INTO pre_req VALUES('11006','11006');
INSERT INTO pre_req VALUES('11007','11007');
INSERT INTO pre_req VALUES('11008','11008');
INSERT INTO pre_req VALUES('11009','11009');
INSERT INTO pre_req VALUES('11010','11010');


-- -----------------------------------------------------
-- Table course_knowledgeskill
-- -----------------------------------------------------
CREATE  TABLE course_knowledgeskill (
 ks_code INT NOT NULL ,
 c_code INT NOT NULL ,
  PRIMARY KEY (ks_code,c_code) ,
      FOREIGN KEY (ks_code )
    REFERENCES knowledge_skill (ks_code )
    ,
     FOREIGN KEY (c_code )
    REFERENCES course (c_code )
    )
;
INSERT INTO course_knowledgeskill VALUES('30001','11001');
INSERT INTO course_knowledgeskill VALUES('30002','11002');
INSERT INTO course_knowledgeskill VALUES('30003','11003');
INSERT INTO course_knowledgeskill VALUES('30004','11004');
INSERT INTO course_knowledgeskill VALUES('30005','11005');
INSERT INTO course_knowledgeskill VALUES('30006','11006');
INSERT INTO course_knowledgeskill VALUES('30007','11007');
INSERT INTO course_knowledgeskill VALUES('30008','11008');
INSERT INTO course_knowledgeskill VALUES('30009','11009');
INSERT INTO course_knowledgeskill VALUES('30010','11010');




CREATE  TABLE job_ks (
 ks_code INT NOT NULL ,
  job_code INT NOT NULL ,
  PRIMARY KEY (ks_code,job_code) ,
     FOREIGN KEY (job_code )
    REFERENCES job (job_code )
    ,
     FOREIGN KEY (ks_code )
    REFERENCES knowledge_skill (ks_code )
    )
;

INSERT INTO job_ks VALUES('30001','40001');
INSERT INTO job_ks VALUES('30002','40002');
INSERT INTO job_ks VALUES('30003','40003');
INSERT INTO job_ks VALUES('30004','40004');
INSERT INTO job_ks VALUES('30005','40005');
INSERT INTO job_ks VALUES('30006','40006');
INSERT INTO job_ks VALUES('30007','40007');
INSERT INTO job_ks VALUES('30008','40008');
INSERT INTO job_ks VALUES('30009','40009');
INSERT INTO job_ks VALUES('30010','40010');
INSERT INTO job_ks VALUES('30001','40002');
INSERT INTO job_ks VALUES('30002','40003');
INSERT INTO job_ks VALUES('30003','40004');
INSERT INTO job_ks VALUES('30004','40005');
INSERT INTO job_ks VALUES('30005','40006');
INSERT INTO job_ks VALUES('30006','40008');
INSERT INTO job_ks VALUES('30007','40009');
INSERT INTO job_ks VALUES('30008','40007');
INSERT INTO job_ks VALUES('30009','40001');
INSERT INTO job_ks VALUES('30010','40002');






-- -----------------------------------------------------
-- Table course_learningunit
-- -----------------------------------------------------
CREATE  TABLE course_learningunit (
 lu_code INT NOT NULL ,
 c_code INT NOT NULL ,
  PRIMARY KEY (lu_code,c_code) ,
    FOREIGN KEY (lu_code )
    REFERENCES learning_unit (lu_code )
    ,
    FOREIGN KEY (c_code )
    REFERENCES course (c_code )
    )
;
INSERT INTO course_learningunit VALUES ('13001','11001');
INSERT INTO course_learningunit VALUES ('13002','11002');
INSERT INTO course_learningunit VALUES ('13003','11003');
INSERT INTO course_learningunit VALUES ('13004','11004');
INSERT INTO course_learningunit VALUES ('13005','11005');
INSERT INTO course_learningunit VALUES ('13006','11006');
INSERT INTO course_learningunit VALUES ('13007','11007');
INSERT INTO course_learningunit VALUES ('13008','11008');
INSERT INTO course_learningunit VALUES ('13009','11009');
INSERT INTO course_learningunit VALUES ('13010','11010');

INSERT INTO course_learningunit VALUES ('13001','11008');
INSERT INTO course_learningunit VALUES ('13002','11007');
INSERT INTO course_learningunit VALUES ('13003','11006');
INSERT INTO course_learningunit VALUES ('13004','11005');
INSERT INTO course_learningunit VALUES ('13005','11004');
INSERT INTO course_learningunit VALUES ('13006','11008');



-- -----------------------------------------------------
-- Table person_job
-- -----------------------------------------------------
CREATE  TABLE person_job (
 person_id INT NOT NULL ,
 job_code INT NOT NULL ,
  PRIMARY KEY (person_id,job_code) ,
     FOREIGN KEY (person_id )
    REFERENCES person (person_id )
    ,
      FOREIGN KEY (job_code )
    REFERENCES job (job_code )
    );
INSERT INTO person_job VALUES ('10001','40002');
INSERT INTO person_job VALUES ('10002','40005');
INSERT INTO person_job VALUES ('10003','40009');
INSERT INTO person_job VALUES ('10004','40010');
INSERT INTO person_job VALUES ('10006','40001');
INSERT INTO person_job VALUES ('10007','40006');
INSERT INTO person_job VALUES ('10008','40007');







CREATE  TABLE person_company (
 company_id INT NOT NULL ,
 person_id INT NOT NULL ,
  PRIMARY KEY (company_id,person_id) ,
     FOREIGN KEY (company_id )
    REFERENCES company (company_id )
    ,
     FOREIGN KEY (person_id )
    REFERENCES person (person_id )
    )
;
INSERT INTO person_company VALUES ('50002','10001');
INSERT INTO person_company VALUES ('50003','10003');
INSERT INTO person_company VALUES ('50005','10007');
INSERT INTO person_company VALUES ('50002','10002');
INSERT INTO person_company VALUES ('50003','10006');
INSERT INTO person_company VALUES ('50004','10004');
INSERT INTO person_company VALUES ('50004','10008');
INSERT INTO person_company VALUES ('50001','10005');
INSERT INTO person_company VALUES ('50005','10009');
INSERT INTO person_company VALUES ('50001','10010');

CREATE  TABLE sessions_person (
 session_id INT NOT NULL ,
 person_id INT NOT NULL ,
  PRIMARY KEY (session_id,person_id) ,
     FOREIGN KEY (session_id )
    REFERENCES sessions (session_id )
    ,
     FOREIGN KEY (person_id )
    REFERENCES person (person_id )
    )
;
INSERT INTO sessions_person VALUES ('12010','10007');
INSERT INTO sessions_person VALUES ('12001','10008');
INSERT INTO sessions_person VALUES ('12004','10004');
INSERT INTO sessions_person VALUES ('12003','10002');
INSERT INTO sessions_person VALUES ('12007','10001');
INSERT INTO sessions_person VALUES ('12005','10009');
INSERT INTO sessions_person VALUES ('12008','10002');
INSERT INTO sessions_person VALUES ('12006','10003');
INSERT INTO sessions_person VALUES ('12004','10005');
INSERT INTO sessions_person VALUES ('12002','10006');

CREATE  TABLE sessions_formats (
 session_id INT NOT NULL ,
 format_type VARCHAR(25) NOT NULL ,
  PRIMARY KEY (session_id,format_type) ,
     FOREIGN KEY (session_id )
    REFERENCES sessions (session_id )
    ,
     FOREIGN KEY (format_type )
    REFERENCES formats (format_type )
    )
;
INSERT INTO sessions_formats VALUES ('12006','online');
INSERT INTO sessions_formats VALUES ('12003','ct');
INSERT INTO sessions_formats VALUES ('12001','online');
INSERT INTO sessions_formats VALUES ('12005','online');
INSERT INTO sessions_formats VALUES ('12008','ct');
INSERT INTO sessions_formats VALUES ('12009','ct');
INSERT INTO sessions_formats VALUES ('12010','online');
INSERT INTO sessions_formats VALUES ('12002','online');
INSERT INTO sessions_formats VALUES ('12004','ct');
INSERT INTO sessions_formats VALUES ('12007','online');


