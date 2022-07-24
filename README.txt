# ВНИМАНИЕ! Для выполнения команд необходимы пакеты JDK и Maven
# Для запуска приложения из консоли выполните следующие команды
cd ChaseLogic ; mvn install
cd ../Game; mvn install

java -jar target/game.jar --enemiesCount 10 --wallsCount 10 --size 30 --profile production