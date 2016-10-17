#!/bin/bash

if [ "$TRAVIS_BRANCH" == "master" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ]; then
    echo 'Master branch: trigger QA'
    gradle sonarqube
elif [ "$TRAVIS_PULL_REQUEST" != "false" ] && [ -n "${GITHUB_TOKEN:-}" ]; then
    echo 'Pull request: trigger QA and preview analysis'

    gradle sonarqube -Dsonar.github.oauth=$GITHUB_TOKEN \
        -Dsonar.github.repository=$TRAVIS_REPO_SLUG \
        -Dsonar.github.pullRequest=$TRAVIS_PULL_REQUEST \
        -Dsonar.login=$SONAR_TOKEN \
        -Dsonar.analysis.mode=preview
fi