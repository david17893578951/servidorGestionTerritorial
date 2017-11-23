/*==============================================================*/
/* Table: GTR_ADMINISTRADOR_CONTRATO                            */
/*==============================================================*/
create table GTR_ADMINISTRADOR_CONTRATO (
   ADC_ID               SERIAL               not null,
   CAS_ID               INT4                 null,
   ADC_ADMINISTRADOR    VARCHAR(30)          null,
   ADC_DIRECCION_ADM    VARCHAR(200)         null,
   ADC_FECHA_INICIO     DATE                 null,
   ADC_FECHA_FIN        DATE                 null,
   ADC_ESTADO           CHAR(1)              null,
   constraint pk_gtr_administrador_contrato primary key (ADC_ID)
)
WITH (
  OIDS=FALSE
);

comment on table GTR_ADMINISTRADOR_CONTRATO is
'tabla de administracion de contrato';

comment on column GTR_ADMINISTRADOR_CONTRATO.ADC_ID is
'identificador clave primaria de un administrador de contrato';

comment on column GTR_ADMINISTRADOR_CONTRATO.CAS_ID is
'identificador clave foranea  de un contrato asignado';

comment on column GTR_ADMINISTRADOR_CONTRATO.ADC_ADMINISTRADOR is
'identificador administrador de un administrador de contrato';

comment on column GTR_ADMINISTRADOR_CONTRATO.ADC_DIRECCION_ADM is
'identificador direccion adm de un administrador de contrato';

comment on column GTR_ADMINISTRADOR_CONTRATO.ADC_FECHA_INICIO is
'identificador fecha de inicio de un administrador de contrato';

comment on column GTR_ADMINISTRADOR_CONTRATO.ADC_FECHA_FIN is
'identificador fecha fin de un administrador de contrato';

comment on column GTR_ADMINISTRADOR_CONTRATO.ADC_ESTADO is
'identificador  estado de un administrador de contrato';

/*==============================================================*/
/* Table: GTR_ASIGNACION_SUELO                                  */
/*==============================================================*/
create table GTR_ASIGNACION_SUELO (
   SUE_ID               SERIAL               not null,
   ZON_ID               VARCHAR(100)         null,
   HID_ID               INT4                 null,
   SUE_ACTIVIDAD        VARCHAR(254)         null,
   SUE_ASIGNACION       VARCHAR(100)         null,
   SUE_FECHA_INICIO     DATE                 null,
   SUE_FECHA_FIN        DATE                 null,
   SUE_ESTADO           CHAR(1)              null,
   SUE_OBSERVACION      VARCHAR(254)         null,
   SUE_TIPO             VARCHAR(50)          null,
   SUE_NUMERO_ANIOS     INT4                 null,
   SUE_UNIDAD_TIEMPO    VARCHAR(30)          null,
   SUE_NOMBRE           VARCHAR(100)         null,
   SUE_DESCRIPCION      VARCHAR(254)         null,
   SUE_TIPO_REGULACION  VARCHAR(50)          null,
   SUE_DIRECCION_RESPONSABLE VARCHAR(200)         null,
   SUE_RESPONSABLE      VARCHAR(50)          null,
   SUE_FIGURA_LEGAL     VARCHAR(20)          null,
   SUE_APLICA_REGULACION_AMBIENTAL BOOL                 null,
   SUE_SUPERFICIE_SOLICITADA NUMERIC              null,
   SUE_SUPERFICIE_ASIGNADA NUMERIC              null,
   SUE_UNIDAD_SUP_ASIGNADA VARCHAR(30)          null,
   SUE_UNIDAD_SUP_SOLICITADA VARCHAR(30)          null,
   SUE_ENTE_APROBADOR   VARCHAR(30)          null,
   SUE_APLICA_POLITICA_INCENTIVOS BOOL                 null,
   SUE_OBS_POLITICA_INCENTIVOS VARCHAR(250)         null,
   constraint pk_gtr_asignacion_suelo primary key (SUE_ID)
)
WITH (
  OIDS=FALSE
);

comment on table GTR_ASIGNACION_SUELO is
'tabla de asignacion de suelos';

comment on column GTR_ASIGNACION_SUELO.SUE_ID is
'Identificador de tabla';

comment on column GTR_ASIGNACION_SUELO.ZON_ID is
'Identificador de zona';

comment on column GTR_ASIGNACION_SUELO.HID_ID is
'Identificador de fuente hidrica';

comment on column GTR_ASIGNACION_SUELO.SUE_ACTIVIDAD is
'Identificador de actividade de la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_ASIGNACION is
'Identificador de nombre de quien recibe la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_FECHA_INICIO is
'Identificador de la fecha de inicio';

comment on column GTR_ASIGNACION_SUELO.SUE_FECHA_FIN is
'Identificador de fecha de finalización';

comment on column GTR_ASIGNACION_SUELO.SUE_ESTADO is
'Identificador de Estado de la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_OBSERVACION is
'Identificador de observación';

comment on column GTR_ASIGNACION_SUELO.SUE_TIPO is
'Identificador de tipo';

comment on column GTR_ASIGNACION_SUELO.SUE_NUMERO_ANIOS is
'Identificador de número de años';

comment on column GTR_ASIGNACION_SUELO.SUE_UNIDAD_TIEMPO is
'Identificador de unidad de tiempo (temporalidad)';

comment on column GTR_ASIGNACION_SUELO.SUE_NOMBRE is
'Identificador de nombre de la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_DESCRIPCION is
'Identificador de descripción';

comment on column GTR_ASIGNACION_SUELO.SUE_TIPO_REGULACION is
'Identificador de tipo de regulación';

comment on column GTR_ASIGNACION_SUELO.SUE_DIRECCION_RESPONSABLE is
'Identificador de Dirección responsable de la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_RESPONSABLE is
'Identificador de funcionario responsable';

comment on column GTR_ASIGNACION_SUELO.SUE_FIGURA_LEGAL is
'Identificador de la fifura legal de la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_SUPERFICIE_SOLICITADA is
'Identificador de superficie solicitada';

comment on column GTR_ASIGNACION_SUELO.SUE_SUPERFICIE_ASIGNADA is
'Identificador de superficie asignada';

comment on column GTR_ASIGNACION_SUELO.SUE_UNIDAD_SUP_ASIGNADA is
'Identificador de unidad de medida de la superficie asignada ';

comment on column GTR_ASIGNACION_SUELO.SUE_UNIDAD_SUP_SOLICITADA is
'Identificador de unidad de medida de la superficie solicitada ';

comment on column GTR_ASIGNACION_SUELO.SUE_ENTE_APROBADOR is
'Identificador del ente aprobador de la asignación';

comment on column GTR_ASIGNACION_SUELO.SUE_APLICA_POLITICA_INCENTIVOS is
'Identificador de aplica política de incentivos';

comment on column GTR_ASIGNACION_SUELO.SUE_OBS_POLITICA_INCENTIVOS is
'Identificador de observaciones de política de incentivos';

/*==============================================================*/
/* Table: GTR_CONTRATO_ASIGNACION                               */
/*==============================================================*/
create table GTR_CONTRATO_ASIGNACION (
   CAS_ID               SERIAL               not null,
   SUE_ID               INT4                 null,
   CAS_FECHA_INICIO     TIMESTAMP            null,
   CAS_FECHA_FIN        TIMESTAMP            null,
   CAS_ARRENDADOR       VARCHAR(250)         null,
   CAS_ARRENDATARIO     VARCHAR(250)         null,
   CAS_PRECIO           NUMERIC              null,
   CAS_PERIODICIDAD_PAGO NUMERIC              null,
   CAS_UNIDAD_TIEMPO    VARCHAR(30)          null,
   CAS_ESTADO           CHAR(1)              null,
   CAS_TIPO             VARCHAR(30)          null,
   CAS_FECHA_SUBIDA_CONTRATO TIMESTAMP            null,
   CAS_CODIGO_CONTRATO  VARCHAR(50)          null,
   CAS_TERMINACION_CONTRACTUAL BOOL                 null,
   CAS_RAZON_TERMINACION_CONT VARCHAR(100)         null,
   CAS_OBSERVACIONES    VARCHAR(250)         null,
   CAS_NUMERO_ALICUOTAS INT4                 null,
   CAS_FECHA_FINALIZACION TIMESTAMP            null,
   constraint pk_gtr_contrato_asignacion primary key (CAS_ID)
)
WITH (
  OIDS=FALSE
);

comment on table GTR_CONTRATO_ASIGNACION is
'tabla de contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_ID is
'identificador clave primaria de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.SUE_ID is
'Identificador de tabla asignacion de suelos';

comment on column GTR_CONTRATO_ASIGNACION.CAS_FECHA_INICIO is
'identificador fecha de inicio de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_FECHA_FIN is
'identificador fecha fin de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_ARRENDADOR is
'identificador arrendador de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_ARRENDATARIO is
'identificador arrendatario de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_PRECIO is
'identificador precio de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_PERIODICIDAD_PAGO is
'identificador periodicidad de pago de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_UNIDAD_TIEMPO is
'identificador unidad de tiempo de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_ESTADO is
'identificador estado de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_TIPO is
'identificador tipo de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_FECHA_SUBIDA_CONTRATO is
'identificador fecha de subida de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_CODIGO_CONTRATO is
'identificador numero codigo de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_TERMINACION_CONTRACTUAL is
'identificador terminacion contractual de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_RAZON_TERMINACION_CONT is
'identificador razon de terminacion de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_OBSERVACIONES is
'identificador observaciones de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_NUMERO_ALICUOTAS is
'identificador numero de alicuota de un contrato asignado';

comment on column GTR_CONTRATO_ASIGNACION.CAS_FECHA_FINALIZACION is
'identificador fecha de finalizacion de un contrato asignado';

/*==============================================================*/
/* Table: GTR_DOCUMENTO                                         */
/*==============================================================*/
create table GTR_DOCUMENTO (
   DOC_ID               SERIAL               not null,
   TDO_ID               INT4                 null,
   DOC_INFORMACION      VARCHAR(250)         null,
   DOC_FECHA_ESTABLECIDA DATE                 null,
   DOC_FECHA_HORA_SUBIDO TIMESTAMP            null,
   DOC_USUA_RESPONSABLE VARCHAR(30)          null,
   constraint PK_GTR_DOCUMENTO primary key (DOC_ID)
);

comment on table GTR_DOCUMENTO is
'tabla de documentos';

comment on column GTR_DOCUMENTO.DOC_ID is
'identificador PK del documento';

comment on column GTR_DOCUMENTO.TDO_ID is
'identificador clave primaria de documentos';

comment on column GTR_DOCUMENTO.DOC_INFORMACION is
'Identificador de la informacion de documentos';

comment on column GTR_DOCUMENTO.DOC_FECHA_ESTABLECIDA is
'Identificador de la fecha establecida a subir el documento';

comment on column GTR_DOCUMENTO.DOC_FECHA_HORA_SUBIDO is
'Identificador de la hora y fecha que subio el documento';

comment on column GTR_DOCUMENTO.DOC_USUA_RESPONSABLE is
'Identificador del usuario responsable que sube el documento';

/*==============================================================*/
/* Table: GTR_ENTREGABLES_CONTRATO                              */
/*==============================================================*/
create table GTR_ENTREGABLES_CONTRATO (
   ECO_ID               SERIAL               not null,
   CAS_ID               INT4                 null,
   ECO_DOCUMENTO        VARCHAR(250)         null,
   ECO_RESPONSABLE      VARCHAR(20)          null,
   ECO_FECHA_MAX_ENTREGA TIMESTAMP            null,
   ECO_FECHA_SUBIDA     TIMESTAMP            null,
   ECO_USUARIO_SUBIDA   VARCHAR(30)          null,
   ECO_ESTADO           CHAR(1)              null,
   ECO_NOMBRE_ENTREGABLE VARCHAR(250)         null,
   constraint pk_gtr_entregables_contrato primary key (ECO_ID)
)
WITH (
  OIDS=FALSE
);

comment on table GTR_ENTREGABLES_CONTRATO is
'tabla de entregables de contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_ID is
'identificador clave primaria de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.CAS_ID is
'identificador clave foranea de contrato asignado';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_DOCUMENTO is
'identificador documento de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_RESPONSABLE is
'identificador responsable de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_FECHA_MAX_ENTREGA is
'identificador fecha maxima de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_FECHA_SUBIDA is
'identificador fecha e subida de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_USUARIO_SUBIDA is
'identificador usuario de subida de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_ESTADO is
'identificador estado de un entregables del contrato';

comment on column GTR_ENTREGABLES_CONTRATO.ECO_NOMBRE_ENTREGABLE is
'identificador nombre de un entregables del contrato';

/*==============================================================*/
/* Table: GTR_FUENTE_HIDRICA                                    */
/*==============================================================*/
create table GTR_FUENTE_HIDRICA (
   HID_ID               SERIAL               not null,
   HID_FUENTE_HIDRICA   VARCHAR(50)          null,
   HID_CONCESION_FUENTE_HIDRICA VARCHAR(50)          null,
   HID_RESPONSABLE_CONCESION VARCHAR(50)          null,
   HID_CAUDAL_ASIGNADO  VARCHAR(50)          null,
   HID_CUADAL_TOTAL     VARCHAR(50)          null,
   constraint PK_GTR_FUENTE_HIDRICA primary key (HID_ID)
);

comment on table GTR_FUENTE_HIDRICA is
'tabla asignacion hidrica';

comment on column GTR_FUENTE_HIDRICA.HID_ID is
'Identificador  clave primaria de la tabla fuente hidrica';

comment on column GTR_FUENTE_HIDRICA.HID_FUENTE_HIDRICA is
'Identificador nombre de la fuente hidrica';

comment on column GTR_FUENTE_HIDRICA.HID_CONCESION_FUENTE_HIDRICA is
'Identificador concesion de la fuente hidrica';

comment on column GTR_FUENTE_HIDRICA.HID_RESPONSABLE_CONCESION is
'Identificador responsable de la concesion de la fuente hidrica';

comment on column GTR_FUENTE_HIDRICA.HID_CAUDAL_ASIGNADO is
'Identificador caudal asignado de la fuente hidrica';

comment on column GTR_FUENTE_HIDRICA.HID_CUADAL_TOTAL is
'Identificador caudal total de la fuente hidrica';

/*==============================================================*/
/* Table: GTR_HISTORIAL_SEGUIMIENTO                             */
/*==============================================================*/
create table GTR_HISTORIAL_SEGUIMIENTO (
   HSE_ID               SERIAL               not null,
   SUE_ID               INT4                 null,
   HSE_USUARIO          VARCHAR(50)          null,
   HSE_FECHA            DATE                 null,
   HSE_FECHA_REGISTRO   TIMESTAMP            null,
   HSE_RESPONSABLE      VARCHAR(50)          null,
   HSE_NOVEDADES        VARCHAR(254)         null,
   HSE_ADJUNTO_DOC      VARCHAR(100)         null,
   HSE_ADJUNTO_FOT      VARCHAR(100)         null,
   HSE_ESTADO           CHAR(1)              null,
   constraint pk_gtr_historial_seguimiento primary key (HSE_ID)
)
WITH (
  OIDS=FALSE
);

comment on table GTR_HISTORIAL_SEGUIMIENTO is
'Tabla del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.SUE_ID is
'Identificador de tabla';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_USUARIO is
'Identificador usuario del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_FECHA is
'Identificador fecha del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_FECHA_REGISTRO is
'Identificador fecha de registro del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_RESPONSABLE is
'Identificador responsable del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_NOVEDADES is
'Identificador de novedades del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_ADJUNTO_DOC is
'Identificador adjunto documento del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_ADJUNTO_FOT is
'Identificador foto adjuntada del historial de seguimiento';

comment on column GTR_HISTORIAL_SEGUIMIENTO.HSE_ESTADO is
'Identificador del estado del historial de seguimiento';

/*==============================================================*/
/* Table: GTR_PAGO                                              */
/*==============================================================*/
create table GTR_PAGO (
   PAG_ID               SERIAL               not null,
   CAS_ID               INT4                 null,
   PAG_TIPO_PAGO        VARCHAR(30)          null,
   PAG_PAGO_REGISTRADO  BOOL                 null,
   PAG_MES              VARCHAR(50)          null,
   PAG_BASE_IMPONIBLE   VARCHAR(50)          null,
   PAG_IVA              NUMERIC              null,
   PAG_FECHA_PAGO_ACORDADA TIMESTAMP WITH TIME ZONE null,
   PAG_FECHA_PAGO_EFECTIVO TIMESTAMP WITH TIME ZONE null,
   PAG_NUM_DIAS_RETRASO NUMERIC              null,
   PAG_MULTAS           NUMERIC              null,
   PAG_OBSERVACION      VARCHAR(250)         null,
   PAG_DESCRIPCION      VARCHAR(250)         null,
   constraint PK_GTR_PAGO primary key (PAG_ID)
);

comment on table GTR_PAGO is
'tabla de pagos';

comment on column GTR_PAGO.PAG_ID is
'identificador clave primaria de pagos';

comment on column GTR_PAGO.CAS_ID is
'identificador clave foranea de contrato asignado';

comment on column GTR_PAGO.PAG_TIPO_PAGO is
'Identificador especifica el tipo de pago (contractual/alicuota)';

comment on column GTR_PAGO.PAG_PAGO_REGISTRADO is
'identificador pago registrado de pagos';

comment on column GTR_PAGO.PAG_MES is
'identificador mes de pagos';

comment on column GTR_PAGO.PAG_BASE_IMPONIBLE is
'identificador base imposible de pagos';

comment on column GTR_PAGO.PAG_IVA is
'identificador iva de pagos';

comment on column GTR_PAGO.PAG_FECHA_PAGO_ACORDADA is
'identificador fecha de pagos acordados';

comment on column GTR_PAGO.PAG_FECHA_PAGO_EFECTIVO is
'identificador fecha de pago efectivo';

comment on column GTR_PAGO.PAG_NUM_DIAS_RETRASO is
'identificador numero de dias de retraso de pagos';

comment on column GTR_PAGO.PAG_MULTAS is
'identificador multa de pagos';

comment on column GTR_PAGO.PAG_OBSERVACION is
'identificador observacion de pagos';

comment on column GTR_PAGO.PAG_DESCRIPCION is
'identificador descripcion de pagos';

/*==============================================================*/
/* Table: GTR_TIPO_DOCUMENTO                                    */
/*==============================================================*/
create table GTR_TIPO_DOCUMENTO (
   TDO_ID               SERIAL               not null,
   TDO_NOMBRE           VARCHAR(30)          null,
   TDO_ESTADO           VARCHAR(30)          null,
   constraint PK_GTR_TIPO_DOCUMENTO primary key (TDO_ID)
);

comment on table GTR_TIPO_DOCUMENTO is
'tabla de tipos de documentos';

comment on column GTR_TIPO_DOCUMENTO.TDO_NOMBRE is
'identificador nombre de los documentos';

comment on column GTR_TIPO_DOCUMENTO.TDO_ESTADO is
'identificador estado  de documentos';

/*==============================================================*/
/* Table: GTR_ZONAS                                             */
/*==============================================================*/
create table GTR_ZONAS (
   ZON_ID               VARCHAR(100)         not null,
   ZON_NOMBRE           VARCHAR(100)         null,
   ZON_DESCRIPCION      VARCHAR(254)         null,
   ZON_HECTAREAS        NUMERIC              null,
   ZON_METROS_CUADRADOS NUMERIC              null,
   ZON_ESTADO           CHAR                 null,
   ZON_LINK_MAPA        VARCHAR(500)         null,
   ZON_LINK_PDF         VARCHAR(500)         null,
   constraint PK_GTR_ZONAS primary key (ZON_ID)
);

comment on table GTR_ZONAS is
'tabla de zanas';

alter table GTR_ADMINISTRADOR_CONTRATO
   add constraint FK_GTR_ADMI_FK_GTR_AD_GTR_CONT foreign key (CAS_ID)
      references GTR_CONTRATO_ASIGNACION (CAS_ID)
      on delete restrict on update restrict;

alter table GTR_ASIGNACION_SUELO
   add constraint FK_GTR_ASIG_FK_GTR_AS_GTR_ZONA foreign key (ZON_ID)
      references GTR_ZONAS (ZON_ID)
      on delete restrict on update restrict;

alter table GTR_ASIGNACION_SUELO
   add constraint FK_GTR_ASIG_FK_GTR_AS_GTR_FUEN foreign key (HID_ID)
      references GTR_FUENTE_HIDRICA (HID_ID)
      on delete restrict on update restrict;

alter table GTR_CONTRATO_ASIGNACION
   add constraint FK_GTR_CONT_FK_GTR_CO_GTR_ASIG foreign key (SUE_ID)
      references GTR_ASIGNACION_SUELO (SUE_ID)
      on delete restrict on update restrict;

alter table GTR_DOCUMENTO
   add constraint FK_GTR_DOCU_FK_GTR_DO_GTR_TIPO foreign key (TDO_ID)
      references GTR_TIPO_DOCUMENTO (TDO_ID)
      on delete restrict on update restrict;

alter table GTR_ENTREGABLES_CONTRATO
   add constraint FK_GTR_ENTR_FK_GTR_EN_GTR_CONT foreign key (CAS_ID)
      references GTR_CONTRATO_ASIGNACION (CAS_ID)
      on delete restrict on update restrict;

alter table GTR_HISTORIAL_SEGUIMIENTO
   add constraint FK_GTR_HIST_FK_GTR_HI_GTR_ASIG foreign key (SUE_ID)
      references GTR_ASIGNACION_SUELO (SUE_ID)
      on delete restrict on update restrict;

alter table GTR_PAGO
   add constraint FK_GTR_PAGO_FK_GTR_PA_GTR_CONT foreign key (CAS_ID)
      references GTR_CONTRATO_ASIGNACION (CAS_ID)
      on delete restrict on update restrict;