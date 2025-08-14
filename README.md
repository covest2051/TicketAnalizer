## Ответ на поставленную задачу: 
Min flight time (in hours and minutes) for each carrier:

Carrier SU: 6h 0m

Carrier S7: 6h 30m

Carrier TK: 5h 50m

Carrier BA: 8h 5m

The difference between the average price and the median: 460,00

## Полный вывод в PowerShell:
PS D:\RarelyUsed\Java projects\BogdanStashchukCourse\TicketAnalizer>  mvn compile exec:java "-Dexec.mainClass=Main" "-Dexec.args=tickets.json"

>>
>>
[INFO] Scanning for projects...

[INFO]

[INFO] ---------------------< org.example:TicketAnalizer >---------------------

[INFO] Building TicketAnalizer 1.0-SNAPSHOT

[INFO]   from pom.xml

[INFO] --------------------------------[ jar ]---------------------------------

[INFO]

[INFO] --- resources:3.3.1:resources (default-resources) @ TicketAnalizer ---

[INFO] Copying 0 resource from src\main\resources to target\classes

[INFO]

[INFO] --- compiler:3.11.0:compile (default-compile) @ TicketAnalizer ---

[INFO] Nothing to compile - all classes are up to date

[INFO]

[INFO] --- exec:3.1.0:java (default-cli) @ TicketAnalizer ---

Min flight time (in hours and minutes) for each carrier:

Carrier SU: 6h 0m

Carrier S7: 6h 30m

Carrier TK: 5h 50m

Carrier BA: 8h 5m

The difference between the average price and the median: 460,00

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  0.671 s

[INFO] Finished at: 2025-08-14T11:21:39+03:00

[INFO] ------------------------------------------------------------------------

PS D:\RarelyUsed\Java projects\BogdanStashchukCourse\TicketAnalizer>
