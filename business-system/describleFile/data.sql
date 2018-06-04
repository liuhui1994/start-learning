-----------------
create sequence notice_id_sequence
increment by 1 
minvalue 1 
no maxvalue start with 1; 

create sequence mobile_code_id_sequence
increment by 1 
minvalue 1 
no maxvalue start with 1;

create sequence user_id_sequence
increment by 1 
minvalue 10000 
no maxvalue start with 10000;

create sequence account_id_sequence
increment by 1 
minvalue 1 
no maxvalue start with 1;

-- ----------------------------
-- Table structure for t_system_mobile_code
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_mobile_code";
CREATE TABLE "public"."t_system_mobile_code" (
"id" int8  DEFAULT nextval('mobile_code_id_sequence'::regclass) NOT NULL,
"code" varchar(20) COLLATE "default" NOT NULL,
"mobile" varchar(20) COLLATE "default" NOT NULL,
"expire_date" timestamp(6) NOT NULL,
"is_validate" varchar(20) COLLATE "default" NOT NULL,
"business_type" varchar(20) COLLATE "default" NOT NULL,
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" int4 NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_mobile_code"."id" IS 'id';
COMMENT ON COLUMN "public"."t_system_mobile_code"."code" IS '验证码';
COMMENT ON COLUMN "public"."t_system_mobile_code"."mobile" IS '联系方式';
COMMENT ON COLUMN "public"."t_system_mobile_code"."expire_date" IS '有效截止时间';
COMMENT ON COLUMN "public"."t_system_mobile_code"."is_validate" IS '是否验证';
COMMENT ON COLUMN "public"."t_system_mobile_code"."business_type" IS '业务类型';
COMMENT ON COLUMN "public"."t_system_mobile_code"."create_date" IS '创建时间';
COMMENT ON COLUMN "public"."t_system_mobile_code"."modify_date" IS '修改时间';
COMMENT ON COLUMN "public"."t_system_mobile_code"."status" IS '是否删除';
COMMENT ON COLUMN "public"."t_system_mobile_code"."creator" IS '创建人';
COMMENT ON COLUMN "public"."t_system_mobile_code"."modifier" IS '修改人';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_system_mobile_code
-- ----------------------------
ALTER TABLE "public"."t_system_mobile_code" ADD PRIMARY KEY ("id");




-- ----------------------------
-- Table structure for t_system_notice
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_notice";
CREATE TABLE "public"."t_system_notice" (
"id" int8 DEFAULT nextval('notice_id_sequence'::regclass) NOT NULL,
"notice_type" int2 NOT NULL,
"business_no" varchar(50) COLLATE "default",
"notice_title" varchar(50) COLLATE "default",
"notice_desc" varchar(50) COLLATE "default",
"notice_url" varchar(50) COLLATE "default",
"state" int2 NOT NULL,
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" int2 NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"sender" varchar(15) COLLATE "default" NOT NULL,
"receiver" varchar(15) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_notice"."id" IS 'id';
COMMENT ON COLUMN "public"."t_system_notice"."notice_type" IS '通知类型';
COMMENT ON COLUMN "public"."t_system_notice"."business_no" IS '业务编号';
COMMENT ON COLUMN "public"."t_system_notice"."notice_title" IS '通知标题';
COMMENT ON COLUMN "public"."t_system_notice"."notice_desc" IS '通知内容';
COMMENT ON COLUMN "public"."t_system_notice"."notice_url" IS '通知url';
COMMENT ON COLUMN "public"."t_system_notice"."state" IS '是否已读';
COMMENT ON COLUMN "public"."t_system_notice"."create_date" IS '创建时间';
COMMENT ON COLUMN "public"."t_system_notice"."modify_date" IS '修改时间';
COMMENT ON COLUMN "public"."t_system_notice"."status" IS '是否删除';
COMMENT ON COLUMN "public"."t_system_notice"."creator" IS '创建人';
COMMENT ON COLUMN "public"."t_system_notice"."modifier" IS '修改人';
COMMENT ON COLUMN "public"."t_system_notice"."sender" IS '发送人';
COMMENT ON COLUMN "public"."t_system_notice"."receiver" IS '接收人';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_system_notice
-- ----------------------------
ALTER TABLE "public"."t_system_notice" ADD PRIMARY KEY ("id");


-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_user";
CREATE TABLE "public"."t_system_user" (
"id" int8  DEFAULT nextval('user_id_sequence'::regclass) NOT NULL,
"login_name" varchar(50) COLLATE "default" NOT NULL,
"password" varchar(50) COLLATE "default" NOT NULL,
"phone" varchar(50) COLLATE "default" NOT NULL,
"pay_account" varchar(50) COLLATE "default" NOT NULL,
"app_id" varchar(50) COLLATE "default" NOT NULL,
"app_key" varchar(50) COLLATE "default" NOT NULL,
"user_type" varchar(20) COLLATE "default" NOT NULL,
"register_ip" varchar(20) COLLATE "default" NOT NULL,
"pay_password" varchar(50) COLLATE "default",
"nick_name" varchar(50) COLLATE "default" NOT NULL,
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" int4 NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"username" varchar(50) COLLATE "default",
"state" varchar(20) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_user"."id" IS 'id';
COMMENT ON COLUMN "public"."t_system_user"."login_name" IS '登陆名';
COMMENT ON COLUMN "public"."t_system_user"."password" IS '密码';
COMMENT ON COLUMN "public"."t_system_user"."phone" IS '联系方式';
COMMENT ON COLUMN "public"."t_system_user"."pay_account" IS '支付宝账号';
COMMENT ON COLUMN "public"."t_system_user"."app_id" IS 'appid';
COMMENT ON COLUMN "public"."t_system_user"."app_key" IS 'appkey';
COMMENT ON COLUMN "public"."t_system_user"."user_type" IS '用户类型';
COMMENT ON COLUMN "public"."t_system_user"."register_ip" IS '注册ip';
COMMENT ON COLUMN "public"."t_system_user"."pay_password" IS '支付密码';
COMMENT ON COLUMN "public"."t_system_user"."nick_name" IS '用户昵称';
COMMENT ON COLUMN "public"."t_system_user"."create_date" IS '创建时间';
COMMENT ON COLUMN "public"."t_system_user"."modify_date" IS '修改时间';
COMMENT ON COLUMN "public"."t_system_user"."status" IS '是否删除';
COMMENT ON COLUMN "public"."t_system_user"."creator" IS '创建人';
COMMENT ON COLUMN "public"."t_system_user"."modifier" IS '修改人';
COMMENT ON COLUMN "public"."t_system_user"."username" IS '用户姓名';
COMMENT ON COLUMN "public"."t_system_user"."state" IS '用户状态';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_system_user
-- ----------------------------
ALTER TABLE "public"."t_system_user" ADD PRIMARY KEY ("id");


-- ----------------------------
-- Table structure for t_system_account
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_account";
CREATE TABLE "public"."t_system_account" (
"id" int8 DEFAULT nextval('account_id_sequence'::regclass) NOT NULL,
"account_id" int8 NOT NULL,
"account_type" varchar(20) COLLATE "default" NOT NULL,
"amount" numeric(20) NOT NULL,
"withdrawal_amount" numeric(20) NOT NULL,
"settlement_amount" numeric(20) NOT NULL,
"update_date" timestamp(6) NOT NULL,
"update_field" varchar(50) COLLATE "default" NOT NULL,
"version" int8 NOT NULL,
"account_state" varchar2(20) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_account"."id" IS 'id';
COMMENT ON COLUMN "public"."t_system_account"."account_id" IS '业务id';
COMMENT ON COLUMN "public"."t_system_account"."account_type" IS '业务类型';
COMMENT ON COLUMN "public"."t_system_account"."amount" IS '账户金额';
COMMENT ON COLUMN "public"."t_system_account"."withdrawal_amount" IS '可提现金额';
COMMENT ON COLUMN "public"."t_system_account"."settlement_amount" IS '结算金额';
COMMENT ON COLUMN "public"."t_system_account"."update_date" IS '更新时间';
COMMENT ON COLUMN "public"."t_system_account"."update_field" IS '校验位';
COMMENT ON COLUMN "public"."t_system_account"."version" IS '版本控制';
COMMENT ON COLUMN "public"."t_system_account"."account_state" IS '账户状态';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_system_account
-- ----------------------------
ALTER TABLE "public"."t_system_account" ADD PRIMARY KEY ("id");
