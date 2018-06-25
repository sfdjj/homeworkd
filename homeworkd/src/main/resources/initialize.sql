DROP TABLE IF EXISTS file_content;
CREATE TABLE file_content(
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL DEFAULT '',
  number INT NOT NULL DEFAULT 0 COMMENT '',
  ch_number INT NOT NULL DEFAULT 0 COMMENT '',
  en_number INT NOT NULL DEFAULT 0 COMMENT '',
  punc_number INT NOT NULL DEFAULT 0 COMMENT '',
  primary key(id)
) engine=InnoDB default charset=utf8;
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题1",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题2",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题3",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题4",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题5",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题6",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题7",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题8",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题9",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题10",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题11",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题12",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题13",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题14",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题15",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题16",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题17",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题18",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题19",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题20",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题21",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题22",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题23",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题24",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题25",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题26",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题27",3,3,3,3);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题28",1,1,1,1);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题29",2,2,2,2);
INSERT INTO file_content(title, number, ch_number, en_number, punc_number) VALUES("标题30",3,3,3,3);