
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START /D %~dp0\R1_����ע������_lite mvn clean spring-boot:run
TIMEOUT /T 10
START /D %~dp0\R2_�����ṩ��_lite mvn clean spring-boot:run
TIMEOUT /T 20
START /D %~dp0\R3_�������ѷ�_lite mvn clean spring-boot:run