alter table gtr_asignacion_suelo drop column hid_id;
alter table gtr_fuente_hidrica add column sue_id integer;
alter table GTR_FUENTE_HIDRICA
   add constraint FK_GTR_FUEN_FK_GTR_FU_GTR_ASIG foreign key (SUE_ID)
      references GTR_ASIGNACION_SUELO (SUE_ID)
      on delete restrict on update restrict;