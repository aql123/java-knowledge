
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5
::TASKKILL /F /FI "WINDOWTITLE eq R3_�������ѷ�_lite*"

START "R1_����ע������_lite" /D %~dp0\R1_����ע������_lite mvn clean spring-boot:run
TIMEOUT /T 10
START "R2_�����ṩ��_lite" /D %~dp0\R2_�����ṩ��_lite mvn clean spring-boot:run
TIMEOUT /T 20
START "R3_�������ѷ�_lite" /D %~dp0\R3_�������ѷ�_lite mvn clean test
