/*==============================================================*/
/* Table: GTR_CATALOGO                                          */
/*==============================================================*/
create table GTR_CATALOGO (
   CAT_ID               SERIAL               not null,
   CAT_CLAVE            VARCHAR(20)          null,
   CAT_CLAVE_PADRE      VARCHAR(20)          null,
   CAT_NOMBRE           VARCHAR(100)         null,
   CAT_DESCRIPCION      VARCHAR(500)         null,
   CAT_ESTADO           VARCHAR(1)           null,
   constraint PK_GTR_CATALOGO primary key (CAT_ID)
);

comment on table GTR_CATALOGO is
'tabla catalogo guardara una lista de select a mostrar en el sistema cliente';

comment on column GTR_CATALOGO.CAT_ID is
'Identificador de la tabla catalogo';

comment on column GTR_CATALOGO.CAT_CLAVE is
'Clave de la lista par los select ';

comment on column GTR_CATALOGO.CAT_CLAVE_PADRE is
'Clave padre de las listas a mostrar en los select del sistema';

comment on column GTR_CATALOGO.CAT_NOMBRE is
'Nombre de cada item a mostrar en los select del sistema';

comment on column GTR_CATALOGO.CAT_DESCRIPCION is
'descripcion de cada nombre de cada item a mostrar en los select del sistema';

comment on column GTR_CATALOGO.CAT_ESTADO is
'Estado de cada item a mostrar en los select del sistema';