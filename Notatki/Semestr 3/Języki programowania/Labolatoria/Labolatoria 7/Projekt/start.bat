start "Keeper" cmd /c "java -jar .\Keeper.jar 1000 & pause"
timeout 1
start "Seller-1" cmd /c "java -jar .\Seller.jar localhost 1000 & pause"
start "Seller-2" cmd /c "java -jar .\Seller.jar localhost 1000 & pause"
timeout 1
start "Deliverer-1" cmd /c "java -jar .\Deliverer.jar localhost 1000 & pause"
start "Deliverer-2" cmd /c "java -jar .\Deliverer.jar localhost 1000 & pause"
start "Deliverer-3" cmd /c "java -jar .\Deliverer.jar localhost 1000 & pause"
start "Deliverer-4" cmd /c "java -jar .\Deliverer.jar localhost 1000 & pause"
timeout 2
start "Customer-1" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-2" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-3" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-4" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-5" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-6" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-7" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-8" cmd /c "java -jar .\Customer.jar localhost 1000 true & pause"
start "Customer-YOU" cmd /c "java -jar .\Customer.jar localhost 1000 false & pause"
