#!/usr/bin/env groovy

def call(String name = 'human') {
  def libraryResource 'banner.txt'
  echo "Hello, ${name}."
}
