
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "F1_����ע������_lite" /D %~dp0\F1_����ע������_lite mvn clean spring-boot:run
TIMEOUT /T 10
START "F2_�����ṩ��_lite" /D %~dp0\F2_�����ṩ��_lite mvn clean spring-boot:run
TIMEOUT /T 20
START "F3_�������ѷ�_lite" /D %~dp0\F3_�������ѷ�_lite mvn clean test