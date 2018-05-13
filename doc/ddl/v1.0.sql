-- auto-generated definition
CREATE TABLE merchant.store_org_info
(
  id                   BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  org_id               BIGINT                              NULL
  COMMENT '组织id',
  org_code             VARCHAR(255)                        NULL
  COMMENT '组织编码',
  audit_status         VARCHAR(255)                        NULL
  COMMENT ' ''审核状态 0待审核,1通过,2不通过''',
  accounting_unit_id   BIGINT                              NULL
  COMMENT '核算单位id',
  store_type           VARCHAR(255)                        NULL
  COMMENT '门店类型 ',
  logo_url             VARCHAR(255)                        NULL
  COMMENT '店铺logo',
  staff_nums           INT                                 NULL
  COMMENT '员工数',
  country_code         VARCHAR(40)                         NULL
  COMMENT '国家',
  country_name         VARCHAR(40)                         NULL
  COMMENT '国家名称',
  province_code        BIGINT(11)                          NULL
  COMMENT '省id',
  province_name        VARCHAR(20)                         NULL
  COMMENT '省名',
  city_code            BIGINT(11)                          NULL
  COMMENT '市id',
  city_name            VARCHAR(20)                         NULL
  COMMENT '市名',
  region_code          BIGINT(11)                          NULL
  COMMENT '区id',
  region_name          VARCHAR(20)                         NULL
  COMMENT '区名',
  detail_address       VARCHAR(400)                        NULL
  COMMENT '详细地址',
  `desc`               VARCHAR(4000)                       NULL
  COMMENT '门店描述',
  is_available         INT(2) DEFAULT '1'                  NOT NULL
  COMMENT '是否可用:默认0否;1是',
  is_deleted           BIGINT DEFAULT '0'                  NOT NULL
  COMMENT '是否已删除',
  version_no           INT DEFAULT '0'                     NOT NULL
  COMMENT '版本',
  create_user_id       BIGINT                              NOT NULL
  COMMENT '创建人',
  create_user_name     VARCHAR(100)                        NULL
  COMMENT '创建人姓名',
  create_user_ip       VARCHAR(60)                         NULL
  COMMENT '创建人IP',
  create_user_mac      VARCHAR(60)                         NULL
  COMMENT '创建人MAC地址',
  create_time          TIMESTAMP                           NULL
  COMMENT '创建时间-应用操作时间',
  create_time_db       TIMESTAMP                           NULL
  COMMENT '创建时间-数据库操作时间',
  update_user_id       BIGINT                              NULL
  COMMENT '修改人',
  update_user_name     VARCHAR(100)                        NULL
  COMMENT '最后修改人姓名',
  update_user_ip       VARCHAR(60)                         NULL
  COMMENT '最后修改人IP',
  update_user_mac      VARCHAR(60)                         NULL
  COMMENT '最后修改人MAC',
  update_time          TIMESTAMP                           NULL
  COMMENT '最后修改时间',
  update_time_db       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL
  COMMENT '最后修改时间-数据库默认写入时间',
  server_ip            VARCHAR(60)                         NULL
  COMMENT '服务器IP',
  company_id           BIGINT                              NOT NULL
  COMMENT '公司ID',
  client_versionno     VARCHAR(40)                         NULL
  COMMENT '客户端程序的版本号',
  business_state       INT DEFAULT '1'                     NULL
  COMMENT '是否接单（是否营业） 1是',
  business_license_url VARCHAR(255)                        NULL
  COMMENT '营业执照url',
  sign_url             VARCHAR(255)                        NULL
  COMMENT '门店招牌url',
  longitude            DECIMAL(9, 6)                       NULL
  COMMENT '店铺的经度',
  latitude             DECIMAL(9, 6)                       NULL
  COMMENT '店铺的纬度'
)
  COMMENT '商家的店铺信息表';



