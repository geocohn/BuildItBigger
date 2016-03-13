# Gradle for Android and Java Project

In this project, I created an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app consists of four modules:
- A Java library that provides jokes
- A Google Could Endpoints (GCE) project that serves those jokes
- An Android Library containing an activity for displaying jokes
- An Android app that fetches jokes from the GCE module and passes them to the Android Library for display

## Why this Project

This was developed for Project 4 as part of the Android Developer Nanodegree program at Udacity.

_As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity._

## Features

* Add free and paid flavors. The free flavor displays a banner ad and runs an interstitial ad before displaying each joke
* Uses a Java library to randomly select from a list of 100 jokes
* Uses the Gradle App Engine plugin to deploy a backend
* Includes an integration test suite that runs against the local App Engine development server

## Integration Testing

Tasks have been added to the project's build.gradle file to run the GCE local development server, run all connected tests, and then shut down the GCE server.

## Authors
George Cohn - Initial work - https://github.com/GeoCohn

