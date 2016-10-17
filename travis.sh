#!/bin/bash

gradle sonarqube -Dsonar.github.oauth=$GITHUB_TOKEN \
    -Dsonar.github.repository=$TRAVIS_REPO_SLUG \
    -Dsonar.github.pullRequest=$TRAVIS_PULL_REQUEST \
    -Dsonar.analysis.mode=preview