# java-notification-bots
java-notification-bots is a small collection of notification bots dev teams and enthusiasts can reference for their projects. It uses spring boot and the spring scheduling system to schedule notifications via Slack, and Twitter to start.

## Pre-Requisites
Free heroku account and java + maven + heroku cli installed on dev machine.

### Dev Environment Setup
clone the repo and perform a <strong>npm install</strong> from within the directory.

Create a .env file with the following:

```
SLACK_WEB_HOOK_URL=[slackwebhookurl]
```

## Testing
### Unit Tests
Simply run the following and jacoco will do the rest :)

```
mvn clean install test
```
### Install Homebrew 
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

### Create a Heroku Account
Create your own personal Heroku account.

### Install the Heroku CLI
Install the Heroku CLI using the following Homebrew command:

```
brew install heroku/brew/heroku
```

### Install Docker
<a href="https://docs.docker.com/install/">https://docs.docker.com/install/</a>

### Authenticating in Heroku
In terminal, run the following:

```
heroku login
```

### Create Heroku App
You can create a Heroku app after authenticating. The following command creates the Heroku app and adds your git remote in order to deploy the app. 

```
heroku create
```
Alternatively, you can specify a name for your app, however, it must be unique as all Heroku names are global.
```
heroku create my-java-bots
```

## Deploying to Heroku
You will need an app already created with the jvm buildpack added.

```
heroku buildpacks:set heroku/jvm
```

Then run the following commands:

```
cd java-notification-bots-worker; mvn heroku:deploy -DskipTests -Dheroku.app.name=java-notification-bots-heroku-app-name
```

This will use the pom modification to deploy heroku slugs using the specified process types and java opts in each project's respective project module.

### Setting up Heroku Scheduled Jobs
Since we used the spring scheduler to schedule our notifications (NotificationScheduler.java), there is no need to create a separate scheduling setup on Heroku.

### Created for Hacktoberfest
:)
