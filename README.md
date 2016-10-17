# Intentify
[![Build Status](https://travis-ci.org/wmeints/intentify.svg?branch=master)](https://travis-ci.org/wmeints/intentify)
[![SonarQube Coverage](https://img.shields.io/sonar/http/sonarqube.com/nl.fizzylogic:intentify/coverage.svg)]()

The goal of intentify is to detect the intent of sentences you send to it. It will also detect any entities in the sentence.
You can use this service to build dialogs for things such as chatbots. I personally use this to control dialogs on the pepper
robot.

## Building the software
The software is written in Kotlin and can be build using Gradle.
Make sure that you have Gradle installed on your computer and run `gradle build` to compile the software.

## Training the model
You can run the application directly from source using `gradle run` or if you have a distribution, you can unpack it on disk and run the application from the bin folder.

Once you have a running instance of the intentify service, execute a `POST` to the url `/api/training/samples`
with the following content:

```
{
  "text": "Your sentence about <myentity>something</myentity>",
  "intent": "something"
}
```

After you submitted several samples to train the service, you can start the training process by posting an empty request
to `/api/training/start`. You can monitor the progress by executing `GET` on `/api/training/status`.

## Detecting the intent of a sentence
If you want to detect what someone means by a particular sentence you can execute a `POST` on `/api/detect`
with the following content:

```
{
  "text": "My sentence about something else."
}
```

You will receive the intent, its score and the entities found in the sentence.
