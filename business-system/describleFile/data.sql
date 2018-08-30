/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90301
Source Host           : localhost:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90301
File Encoding         : 65001

Date: 2018-08-02 18:15:23
*/


-- ----------------------------
-- Sequence structure for account_flow_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."account_flow_id_sequence";
CREATE SEQUENCE "public"."account_flow_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for account_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."account_id_sequence";
CREATE SEQUENCE "public"."account_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."account_id_sequence"', 1, true);

-- ----------------------------
-- Sequence structure for activity_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."activity_id_sequence";
CREATE SEQUENCE "public"."activity_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for activity_rule_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."activity_rule_id_sequence";
CREATE SEQUENCE "public"."activity_rule_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for address_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."address_id_sequence";
CREATE SEQUENCE "public"."address_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for goods_attr_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."goods_attr_id_sequence";
CREATE SEQUENCE "public"."goods_attr_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for goods_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."goods_id_sequence";
CREATE SEQUENCE "public"."goods_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for member_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."member_id_sequence";
CREATE SEQUENCE "public"."member_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 15
 CACHE 1;
SELECT setval('"public"."member_id_sequence"', 15, true);

-- ----------------------------
-- Sequence structure for menu_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."menu_id_sequence";
CREATE SEQUENCE "public"."menu_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for merchant_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."merchant_id_sequence";
CREATE SEQUENCE "public"."merchant_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for mobile_code_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."mobile_code_id_sequence";
CREATE SEQUENCE "public"."mobile_code_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for notice_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."notice_id_sequence";
CREATE SEQUENCE "public"."notice_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for order_id_sequence
-- ----------------------------
CREATE SEQUENCE "public"."order_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for order_item_id_sequence
-- ----------------------------
CREATE SEQUENCE "public"."order_item_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for rule_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."rule_id_sequence";
CREATE SEQUENCE "public"."rule_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for user_id_sequence
-- ----------------------------
DROP SEQUENCE "public"."user_id_sequence";
CREATE SEQUENCE "public"."user_id_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 10014
 CACHE 1;
SELECT setval('"public"."user_id_sequence"', 10014, true);

-- ----------------------------
-- Table structure for t_system_account
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_account";
CREATE TABLE "public"."t_system_account" (
"id" int8 DEFAULT nextval('account_id_sequence'::regclass) NOT NULL,
"account_id" int8 NOT NULL,
"account_type" varchar(20) COLLATE "default" NOT NULL,
"amount" numeric(20,2) NOT NULL,
"withdrawal_amount" numeric(20,2) NOT NULL,
"settlement_amount" numeric(20,2) NOT NULL,
"update_date" timestamp(6) NOT NULL,
"update_field" varchar(50) COLLATE "default" NOT NULL,
"version" int8 NOT NULL,
"account_state" varchar(20) COLLATE "default" NOT NULL
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
-- Table structure for t_system_account_flow
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_account_flow";
CREATE TABLE "public"."t_system_account_flow" (
"id" int8 DEFAULT nextval('account_flow_id_sequence'::regclass) NOT NULL,
"trade_id" int8 NOT NULL,
"flow_type" varchar(20) COLLATE "default" NOT NULL,
"amount" numeric(20) NOT NULL,
"remain_amount" numeric(20) NOT NULL,
"create_date" timestamp(6) NOT NULL,
"remark" varchar COLLATE "default",
"account_id" int8 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_account_flow"."id" IS '流水id';
COMMENT ON COLUMN "public"."t_system_account_flow"."trade_id" IS '关联交易id';
COMMENT ON COLUMN "public"."t_system_account_flow"."flow_type" IS '流水类型';
COMMENT ON COLUMN "public"."t_system_account_flow"."amount" IS '流水金额';
COMMENT ON COLUMN "public"."t_system_account_flow"."remain_amount" IS '账户现有金额';
COMMENT ON COLUMN "public"."t_system_account_flow"."create_date" IS '创建时间';
COMMENT ON COLUMN "public"."t_system_account_flow"."remark" IS '备注';
COMMENT ON COLUMN "public"."t_system_account_flow"."account_id" IS '关联账户';

-- ----------------------------
-- Table structure for t_system_activity
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_activity";
CREATE TABLE "public"."t_system_activity" (
"id" int8 DEFAULT nextval('activity_id_sequence'::regclass) NOT NULL,
"activity_type" varchar(20) COLLATE "default" NOT NULL,
"activity_name" varchar(20) COLLATE "default" NOT NULL,
"limit_date_start" timestamp(6),
"limit_time_area" varchar(80) COLLATE "default",
"budget" numeric(20,2) DEFAULT 0.00 NOT NULL,
"activity_state" varchar(20) COLLATE "default",
"status" varchar(20) COLLATE "default",
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"activity_no" varchar(50) COLLATE "default",
"remark" varchar(100) COLLATE "default",
"limit_date_end" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_activity"."id" IS '主键';
COMMENT ON COLUMN "public"."t_system_activity"."activity_type" IS '活动类型';
COMMENT ON COLUMN "public"."t_system_activity"."activity_name" IS '活动名称';
COMMENT ON COLUMN "public"."t_system_activity"."limit_date_start" IS '活动开始时间限制';
COMMENT ON COLUMN "public"."t_system_activity"."limit_time_area" IS '时间段限制,多时间段,分割';
COMMENT ON COLUMN "public"."t_system_activity"."budget" IS '活动预算';
COMMENT ON COLUMN "public"."t_system_activity"."activity_state" IS '活动状态';
COMMENT ON COLUMN "public"."t_system_activity"."activity_no" IS '活动编号';
COMMENT ON COLUMN "public"."t_system_activity"."remark" IS '备注';
COMMENT ON COLUMN "public"."t_system_activity"."limit_date_end" IS '活动结束时间限制';

-- ----------------------------
-- Table structure for t_system_activity_rule
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_activity_rule";
CREATE TABLE "public"."t_system_activity_rule" (
"id" int8 DEFAULT nextval('activity_rule_id_sequence'::regclass) NOT NULL,
"activity_id" int8 NOT NULL,
"rule_id" int8 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_activity_rule"."activity_id" IS '活动id';
COMMENT ON COLUMN "public"."t_system_activity_rule"."rule_id" IS '规则id';

-- ----------------------------
-- Table structure for t_system_address
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_address";
CREATE TABLE "public"."t_system_address" (
"id" int8 DEFAULT nextval('address_id_sequence'::regclass) NOT NULL,
"user_id" int8 NOT NULL,
"province" varchar(20) COLLATE "default" NOT NULL,
"city" varchar(20) COLLATE "default" NOT NULL,
"area" varchar(20) COLLATE "default" NOT NULL,
"street" varchar(100) COLLATE "default" NOT NULL,
"phone" varchar(20) COLLATE "default" NOT NULL,
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"contact" varchar(20) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_address"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."t_system_address"."province" IS '省份';
COMMENT ON COLUMN "public"."t_system_address"."city" IS '市';
COMMENT ON COLUMN "public"."t_system_address"."area" IS '区域';
COMMENT ON COLUMN "public"."t_system_address"."street" IS '街道';
COMMENT ON COLUMN "public"."t_system_address"."phone" IS '联系方式';

-- ----------------------------
-- Table structure for t_system_goods
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_goods";
CREATE TABLE "public"."t_system_goods" (
"id" int8 DEFAULT nextval('goods_id_sequence'::regclass) NOT NULL,
"goods_serial" varchar(50) COLLATE "default" NOT NULL,
"goods_name" varchar(100) COLLATE "default" NOT NULL,
"describle" varchar(200) COLLATE "default" NOT NULL,
"brand_id" int8,
"merchant_id" int8,
"material" varchar(100) COLLATE "default",
"specifications" varchar(100) COLLATE "default",
"style" varchar(100) COLLATE "default",
"product" varchar(100) COLLATE "default",
"weight" varchar(100) COLLATE "default",
"suitable" varchar(100) COLLATE "default",
"pic" varchar(100) COLLATE "default" NOT NULL,
"detail" varchar(200) COLLATE "default",
"keyword" varchar(100) COLLATE "default" NOT NULL,
"is_invoice" bool NOT NULL,
"is_warranty" bool NOT NULL,
"other_service" varchar(100) COLLATE "default",
"remark" varchar(100) COLLATE "default",
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"one_menu" int8 NOT NULL,
"two_menu" int8 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_goods"."id" IS '商品id';
COMMENT ON COLUMN "public"."t_system_goods"."goods_serial" IS '商品编号';
COMMENT ON COLUMN "public"."t_system_goods"."describle" IS '商品描述';
COMMENT ON COLUMN "public"."t_system_goods"."brand_id" IS '品牌';
COMMENT ON COLUMN "public"."t_system_goods"."merchant_id" IS '所属商户';
COMMENT ON COLUMN "public"."t_system_goods"."specifications" IS '规格';
COMMENT ON COLUMN "public"."t_system_goods"."style" IS '款式';
COMMENT ON COLUMN "public"."t_system_goods"."product" IS '产地';
COMMENT ON COLUMN "public"."t_system_goods"."weight" IS '重量';
COMMENT ON COLUMN "public"."t_system_goods"."suitable" IS '适用对象';
COMMENT ON COLUMN "public"."t_system_goods"."pic" IS '商品主图';
COMMENT ON COLUMN "public"."t_system_goods"."detail" IS '商品详情';
COMMENT ON COLUMN "public"."t_system_goods"."keyword" IS '关键字';
COMMENT ON COLUMN "public"."t_system_goods"."is_invoice" IS '是否开发票';
COMMENT ON COLUMN "public"."t_system_goods"."is_warranty" IS '是否保修';
COMMENT ON COLUMN "public"."t_system_goods"."other_service" IS '其他服务';
COMMENT ON COLUMN "public"."t_system_goods"."remark" IS '备注';

-- ----------------------------
-- Table structure for t_system_goods_attr
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_goods_attr";
CREATE TABLE "public"."t_system_goods_attr" (
"id" int8 DEFAULT nextval('goods_attr_id_sequence'::regclass) NOT NULL,
"goods_id" int8 NOT NULL,
"cost_price" numeric(20,2) NOT NULL,
"sell_price" numeric(20,2) NOT NULL,
"inventory" numeric(20) NOT NULL,
"sales" numeric(20) NOT NULL,
"sku1" varchar(20) COLLATE "default" NOT NULL,
"sku_desc1" varchar(20) COLLATE "default" NOT NULL,
"sku_pic" varchar(50) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_goods_attr"."goods_id" IS '商品id';
COMMENT ON COLUMN "public"."t_system_goods_attr"."cost_price" IS '成本价';
COMMENT ON COLUMN "public"."t_system_goods_attr"."sell_price" IS '售价';
COMMENT ON COLUMN "public"."t_system_goods_attr"."inventory" IS '库存';
COMMENT ON COLUMN "public"."t_system_goods_attr"."sales" IS '销量';
COMMENT ON COLUMN "public"."t_system_goods_attr"."sku1" IS 'sku';
COMMENT ON COLUMN "public"."t_system_goods_attr"."sku_desc1" IS 'sku描述';

-- ----------------------------
-- Table structure for t_system_member
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_member";
CREATE TABLE "public"."t_system_member" (
"id" int8 DEFAULT nextval('member_id_sequence'::regclass) NOT NULL,
"member_name" varchar(50) COLLATE "default" NOT NULL,
"member_phone" varchar(20) COLLATE "default" NOT NULL,
"parent_id" int8,
"status" varchar(20) COLLATE "default" NOT NULL,
"create_date" date NOT NULL,
"modify_date" date NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"remark" varchar(100) COLLATE "default",
"member_type" varchar(20) COLLATE "default" NOT NULL,
"member_state" varchar(20) COLLATE "default" NOT NULL,
"invite_code" varchar(50) COLLATE "default" NOT NULL,
"member_no" varchar(50) COLLATE "default" NOT NULL,
"user_id" int8
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_member"."member_name" IS '会员名称';
COMMENT ON COLUMN "public"."t_system_member"."member_phone" IS '联系方式';
COMMENT ON COLUMN "public"."t_system_member"."parent_id" IS '父级Id';
COMMENT ON COLUMN "public"."t_system_member"."remark" IS '备注';
COMMENT ON COLUMN "public"."t_system_member"."member_type" IS '会员类型';
COMMENT ON COLUMN "public"."t_system_member"."member_state" IS '会员状态';
COMMENT ON COLUMN "public"."t_system_member"."invite_code" IS '会员邀请码';
COMMENT ON COLUMN "public"."t_system_member"."member_no" IS '会员编号';
COMMENT ON COLUMN "public"."t_system_member"."user_id" IS '用户id';

-- ----------------------------
-- Table structure for t_system_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_menu";
CREATE TABLE "public"."t_system_menu" (
"id" int8 DEFAULT nextval('menu_id_sequence'::regclass) NOT NULL,
"menu_name" varchar(50) COLLATE "default" NOT NULL,
"menu_type" varchar(50) COLLATE "default" NOT NULL,
"parent_id" int8
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_menu"."menu_name" IS '类目名称';
COMMENT ON COLUMN "public"."t_system_menu"."menu_type" IS '类目类型';
COMMENT ON COLUMN "public"."t_system_menu"."parent_id" IS '父级id';

-- ----------------------------
-- Table structure for t_system_merchant
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_merchant";
CREATE TABLE "public"."t_system_merchant" (
"id" int8 DEFAULT nextval('merchant_id_sequence'::regclass) NOT NULL,
"merchant_name" varchar(50) COLLATE "default" NOT NULL,
"merchant_type" varchar(20) COLLATE "default" NOT NULL,
"address" varchar(100) COLLATE "default" NOT NULL,
"account_name" varchar(50) COLLATE "default" NOT NULL,
"account_type" varchar(20) COLLATE "default" NOT NULL,
"bank_account" varchar(50) COLLATE "default",
"pay_account" varchar(50) COLLATE "default",
"commision" numeric(20,2) NOT NULL,
"contact" varchar(20) COLLATE "default" NOT NULL,
"phone" varchar(20) COLLATE "default" NOT NULL,
"app_id" varchar(50) COLLATE "default" NOT NULL,
"app_key" varchar(50) COLLATE "default" NOT NULL,
"business_license" varchar(100) COLLATE "default",
"logo" varchar(200) COLLATE "default",
"remark" varchar(200) COLLATE "default",
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_merchant"."merchant_name" IS '商户名称';
COMMENT ON COLUMN "public"."t_system_merchant"."merchant_type" IS '商户类型';
COMMENT ON COLUMN "public"."t_system_merchant"."address" IS '商户地址';
COMMENT ON COLUMN "public"."t_system_merchant"."account_name" IS '账户名';
COMMENT ON COLUMN "public"."t_system_merchant"."account_type" IS '账户类型';
COMMENT ON COLUMN "public"."t_system_merchant"."bank_account" IS '银行卡号';
COMMENT ON COLUMN "public"."t_system_merchant"."pay_account" IS '支付宝号';
COMMENT ON COLUMN "public"."t_system_merchant"."commision" IS '佣金比例';
COMMENT ON COLUMN "public"."t_system_merchant"."contact" IS '联系人';
COMMENT ON COLUMN "public"."t_system_merchant"."phone" IS '联系电话';
COMMENT ON COLUMN "public"."t_system_merchant"."app_id" IS 'app_Id';
COMMENT ON COLUMN "public"."t_system_merchant"."app_key" IS 'app_key';
COMMENT ON COLUMN "public"."t_system_merchant"."business_license" IS '营业执照';
COMMENT ON COLUMN "public"."t_system_merchant"."logo" IS 'logo';
COMMENT ON COLUMN "public"."t_system_merchant"."remark" IS '备注';

-- ----------------------------
-- Table structure for t_system_mobile_code
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_mobile_code";
CREATE TABLE "public"."t_system_mobile_code" (
"id" int8 DEFAULT nextval('mobile_code_id_sequence'::regclass) NOT NULL,
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
-- Table structure for t_system_notice
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_notice";
CREATE TABLE "public"."t_system_notice" (
"id" int8 DEFAULT nextval('notice_id_sequence'::regclass) NOT NULL,
"notice_type" varchar(16) COLLATE "default" NOT NULL,
"business_no" varchar(50) COLLATE "default",
"notice_title" varchar(50) COLLATE "default",
"notice_desc" varchar(50) COLLATE "default",
"notice_url" varchar(50) COLLATE "default",
"state" varchar(16) COLLATE "default" NOT NULL,
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
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
-- Table structure for t_system_order
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_order";
CREATE TABLE "public"."t_system_order" (
"id" int8 NOT NULL,
"order_no" varchar(50) COLLATE "default" NOT NULL,
"trade_type" varchar(50) COLLATE "default" NOT NULL,
"pay_type" varchar(50) COLLATE "default" NOT NULL,
"pay_status" varchar(50) COLLATE "default" NOT NULL,
"out_trade_no" varchar(50) COLLATE "default",
"pay_date_time" timestamp(6),
"pay_price" numeric(20,2),
"order_total_price" numeric(20,2) NOT NULL,
"order_status" varchar(50) COLLATE "default" NOT NULL,
"refund_status" varchar(50) COLLATE "default",
"txn_complete_time" timestamp(6),
"limit_pay_time" timestamp(6) NOT NULL,
"refund_price" numeric(20),
"fee" varchar COLLATE "default",
"create_date" timestamp(6) NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"user_id" int8 NOT NULL,
"merchant_id" int8 NOT NULL,
"order_title" varchar(200) COLLATE "default" NOT NULL,
"award" varchar(50) COLLATE "default",
"collection_address" varchar(50) COLLATE "default" NOT NULL,
"logistics" varchar(200) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_order"."order_no" IS '订单编号';
COMMENT ON COLUMN "public"."t_system_order"."trade_type" IS '交易类型';
COMMENT ON COLUMN "public"."t_system_order"."pay_type" IS '支付类型';
COMMENT ON COLUMN "public"."t_system_order"."pay_status" IS '支付状态';
COMMENT ON COLUMN "public"."t_system_order"."out_trade_no" IS '站外订单号';
COMMENT ON COLUMN "public"."t_system_order"."pay_date_time" IS '支付时间';
COMMENT ON COLUMN "public"."t_system_order"."pay_price" IS '支付金额';
COMMENT ON COLUMN "public"."t_system_order"."order_total_price" IS '订单总金额';
COMMENT ON COLUMN "public"."t_system_order"."order_status" IS '订单状态';
COMMENT ON COLUMN "public"."t_system_order"."txn_complete_time" IS '交易完成时间';
COMMENT ON COLUMN "public"."t_system_order"."limit_pay_time" IS '订单限制支付时间';
COMMENT ON COLUMN "public"."t_system_order"."refund_price" IS '退款金额';
COMMENT ON COLUMN "public"."t_system_order"."order_title" IS '订单说明';
COMMENT ON COLUMN "public"."t_system_order"."award" IS '消费奖励';
COMMENT ON COLUMN "public"."t_system_order"."collection_address" IS '收货地址';
COMMENT ON COLUMN "public"."t_system_order"."logistics" IS '物流信息';

-- ----------------------------
-- Table structure for t_system_order_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_order_item";
CREATE TABLE "public"."t_system_order_item" (
"id" int8 DEFAULT nextval('order_item_id_sequence'::regclass) NOT NULL,
"order_id" int8 NOT NULL,
"goods_name" varchar(200) COLLATE "default" NOT NULL,
"goods_pay_price" numeric(20,2) NOT NULL,
"goods_num" int8 NOT NULL,
"sku" varchar(50) COLLATE "default" NOT NULL,
"sku_desc" varchar(50) COLLATE "default" NOT NULL,
"sku_pic" varchar(200) COLLATE "default" NOT NULL,
"user_id" int8 NOT NULL,
"create_date" timestamp(6) NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_order_item"."order_id" IS '订单id';
COMMENT ON COLUMN "public"."t_system_order_item"."goods_name" IS '商品名称';
COMMENT ON COLUMN "public"."t_system_order_item"."goods_pay_price" IS '商品支付价格';
COMMENT ON COLUMN "public"."t_system_order_item"."goods_num" IS '商品数量';
COMMENT ON COLUMN "public"."t_system_order_item"."sku" IS '商品sku';
COMMENT ON COLUMN "public"."t_system_order_item"."sku_desc" IS '商品sku描述';
COMMENT ON COLUMN "public"."t_system_order_item"."sku_pic" IS '商品sku图';
COMMENT ON COLUMN "public"."t_system_order_item"."user_id" IS '用户id';

-- ----------------------------
-- Table structure for t_system_rule
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_rule";
CREATE TABLE "public"."t_system_rule" (
"id" int8 DEFAULT nextval('rule_id_sequence'::regclass) NOT NULL,
"award_type" varchar(20) COLLATE "default" NOT NULL,
"rule_name" varchar(20) COLLATE "default" NOT NULL,
"limit_type" varchar(80) COLLATE "default",
"the_odds" numeric(20,2) NOT NULL,
"prize" varchar(20) COLLATE "default",
"status" varchar(20) COLLATE "default",
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"creator" varchar(20) COLLATE "default" NOT NULL,
"modifier" varchar(20) COLLATE "default" NOT NULL,
"limit_count" numeric(20),
"remark" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_system_rule"."id" IS '主键';
COMMENT ON COLUMN "public"."t_system_rule"."award_type" IS '奖励类型';
COMMENT ON COLUMN "public"."t_system_rule"."rule_name" IS '规则名称';
COMMENT ON COLUMN "public"."t_system_rule"."limit_type" IS '限制类型';
COMMENT ON COLUMN "public"."t_system_rule"."the_odds" IS '中奖概率';
COMMENT ON COLUMN "public"."t_system_rule"."prize" IS '奖励';
COMMENT ON COLUMN "public"."t_system_rule"."limit_count" IS '限制领取数量';
COMMENT ON COLUMN "public"."t_system_rule"."remark" IS '备注';

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_system_user";
CREATE TABLE "public"."t_system_user" (
"id" int8 DEFAULT nextval('user_id_sequence'::regclass) NOT NULL,
"login_name" varchar(50) COLLATE "default" NOT NULL,
"password" varchar(50) COLLATE "default" NOT NULL,
"phone" varchar(50) COLLATE "default" NOT NULL,
"pay_account" varchar(50) COLLATE "default",
"app_id" varchar(50) COLLATE "default" NOT NULL,
"app_key" varchar(50) COLLATE "default" NOT NULL,
"user_type" varchar(20) COLLATE "default" NOT NULL,
"register_ip" varchar(20) COLLATE "default" NOT NULL,
"pay_password" varchar(50) COLLATE "default",
"nick_name" varchar(50) COLLATE "default",
"create_date" timestamp(6) NOT NULL,
"modify_date" timestamp(6) NOT NULL,
"status" varchar(20) COLLATE "default" NOT NULL,
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
-- Primary Key structure for table t_system_account
-- ----------------------------
ALTER TABLE "public"."t_system_account" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_account_flow
-- ----------------------------
ALTER TABLE "public"."t_system_account_flow" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_activity
-- ----------------------------
ALTER TABLE "public"."t_system_activity" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_activity_rule
-- ----------------------------
ALTER TABLE "public"."t_system_activity_rule" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_address
-- ----------------------------
ALTER TABLE "public"."t_system_address" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_goods
-- ----------------------------
ALTER TABLE "public"."t_system_goods" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_goods_attr
-- ----------------------------
ALTER TABLE "public"."t_system_goods_attr" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_member
-- ----------------------------
ALTER TABLE "public"."t_system_member" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_menu
-- ----------------------------
ALTER TABLE "public"."t_system_menu" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_merchant
-- ----------------------------
ALTER TABLE "public"."t_system_merchant" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_mobile_code
-- ----------------------------
ALTER TABLE "public"."t_system_mobile_code" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_notice
-- ----------------------------
ALTER TABLE "public"."t_system_notice" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_order
-- ----------------------------
ALTER TABLE "public"."t_system_order" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_order_item
-- ----------------------------
ALTER TABLE "public"."t_system_order_item" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_rule
-- ----------------------------
ALTER TABLE "public"."t_system_rule" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_system_user
-- ----------------------------
ALTER TABLE "public"."t_system_user" ADD PRIMARY KEY ("id");






