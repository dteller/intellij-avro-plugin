# IntelliJ Avro Plugin

## Overview

A Tool Window plugin for IntelliJ that displays Avro `.avro` files in human-readable JSON format.

Features include:
 - Foldable schema viewing ([RSyntaxTextArea](https://github.com/bobbylight/RSyntaxTextArea))
 - Tablulated or raw viewing of records
 - Column sorting in table view
 - Automatic flattening of nested records in table view ([json-flattener](https://github.com/wnameless/json-flattener))
 - Configurable number of records to show
 - Simple drag-and-drop interface
 - Automatic support for IntelliJ's default and Darcula themes


## Installing

Available on [the IntelliJ Plugin Marketplace](https://plugins.jetbrains.com/plugin/12281-avro-viewer). Search "Avro Viewer" in IntelliJ's Plugins window.


## Images


##### Table view:

![table view](images/table-view.png "Table view")


##### Raw view:

![raw view](images/raw-view.png "Raw view")


##### Schema view:

![schema view](images/schema-view.png "Schema view")


## Improvements/New Features

Raise a [PR](https://github.com/benwatson528/intellij-avro-plugin/pulls) or [Issue](https://github.com/benwatson528/intellij-avro-plugin/issues).


## Releasing/Building Locally

This project can be build locally and manually imported to IntelliJ. To do this:

1. Build the project with `gradlew clean build`.
2. Take the jar in `build/distributions` and navigate to `Settings` -> `Plugins` -> `Install Plugin From Disk...`.


## License

https://www.apache.org/licenses/LICENSE-2.0
