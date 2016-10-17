#!/bin/bash

gradle sonarqube -Psonar.github.oauth=$GITHUB_TOKEN \
    -Psonar.github.repository=$TRAVIS_REPO_SLUG \
    -Psonar.github.pullRequest=$TRAVI_SPULL_REQUEST \
    -Psonar.analysis.mode=preview