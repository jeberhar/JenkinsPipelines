#!/usr/bin/env groovy

def call(String name = 'human') {
  def banner = libraryResource 'banner.txt'
  echo "Hello, ${name}."
}
