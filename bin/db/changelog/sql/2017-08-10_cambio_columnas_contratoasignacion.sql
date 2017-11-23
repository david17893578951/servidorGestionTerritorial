
alter table gtr_contrato_asignacion rename column cas_fecha_subida_contrato to cas_fecha_creacion_contrato;
/*Cambio de Nombre de la columna  cas_fecha_subida_contrato a cas_fecha_creacion_contrato*/

ALTER TABLE gtr_contrato_asignacion DROP COLUMN cas_unidad_tiempo;
/*eliminacion de la columna cas_unidad_tiempo*/


ALTER TABLE gtr_contrato_asignacion ALTER COLUMN cas_estado TYPE character varying(10)
/*cambio en el tipo de variable de la tabla gtr_contrato_asignacion en la columna estado */