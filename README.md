The Greeting sample app by Mark Ng

#### Build
```bash
./gradlew clean build
```

#### Run Locally

```bash
./gradlew clean greeting-app:bootRun
```

#### Run in IDE (Intellij)
right click on GreetingApp.kt

### Testing
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"firstName":"Mark","lastName":"Ng"}' \
  http://localhost:8080/greeting
```
