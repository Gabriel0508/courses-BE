ALTER TABLE course
DROP COLUMN IF EXISTS IMAGE,
ADD COLUMN image ByteA;
