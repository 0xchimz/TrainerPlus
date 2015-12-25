# TrainerPlus

## Configuring the Database
  1.  First, you need to have MySQL installed, create the database named `trainer-plus` with an encoding set to `UTF-8`

  2.  At the root directory of the project(TrainerPlus), edit the file `conf/application.conf`

  using the following command (in linux)
  ```
  vi conf/application.conf
  ```

  3.  Look for the `Database Configuration` section, you should see something like ..
  ```
  # Database configuration
  # ~~~~~
  # You can declare as many datasources as you want.
  # By convention, the default datasource is named `default`
  #
  db.default.driver=org.mariadb.jdbc.Driver
  db.default.url="jdbc:mysql://localhost:3306/trainer-plus?characterEncoding=UTF-8"
  db.default.user=root
  db.default.password=""
  applyEvolutions.default=true
  ```

  4.  Edit the `db.default.url`, `db.default.user`, `db.default.password` to match your database configuration, eg.
  ```
  db.default.url="jdbc:mysql://localhost:3306/trainer-plus?characterEncoding=UTF-8"
  db.default.user="test"
  db.default.password="test1234"
  ```

# Running the project

## Download Play Activator
  1.  First, download the `Play Activator` from [Play Framework](https://www.playframework.com/download)
    > The [1.3.7 minimal distribution](https://downloads.typesafe.com/typesafe-activator/1.3.7/typesafe-activator-1.3.7-minimal.zip) or the [1.3.7 offline distribution](https://downloads.typesafe.com/typesafe-activator/1.3.7/typesafe-activator-1.3.7.zip)

  2.  extract the dowloaded `1.3.7 Play activator` by

      ```
      unzip typesafe-activator-1.3.7-minimal.zip
      ```
      or (if you choose the offline distribution)

      ```
      unzip typesafe-activator-1.3.7.zip
      ```

## Run the Project

  There are various solutions to run the project, choose one of the solutions that you prefer, or you can visit [Play Framework Installation](https://www.playframework.com/documentation/2.4.x/Installing) for more information.

  ### Optional - Add Executable to path
  > For convenience, you should add the Activator installation directory to your system PATH.

  >On `Unix`, use `export PATH=/path/to/activator:$PATH`   
  >On `Windows`, add `;C:\path\to\activator` to your PATH environment variable. Do not use a path with spaces.

### Solution 1 (Run it right away)
  1.  Copy 3 files which are `activator`, `activator.bat`, `activator-launch-1.3.7.jar` to the `TrainerPlus` directory, by

      (replace `activator-1.3.7-minimal` path with `activator-dist-1.3.7` if you choose the offline one)
      ```

      cp activator-1.3.7-minimal/activator-launch-1.3.7.jar TrainerPlus
      cp activator-1.3.7-minimal/activator TrainerPlus
      cp activator-1.3.7-minimal/activator.bat TrainerPlus
      ```

  2.  Move to TrainerPlus directory, run the project by executing `activator run`

      ```
      cd TrainerPlus
      ./activator run
      ```

      or (if you already added PATH)
      ```
      cd TrainerPlus
      activator run
      ```

      You should see something like
      ```
      [info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
      ```

### Solution 2 (Package)

  1.  Copy 3 files which are `activator`, `activator.bat`, `activator-launch-1.3.7.jar` to the `TrainerPlus` directory, by

      (replace `activator-1.3.7-minimal` path with `activator-dist-1.3.7` if you choose the offline one)
      ```

      cp activator-1.3.7-minimal/activator-launch-1.3.7.jar TrainerPlus
      cp activator-1.3.7-minimal/activator TrainerPlus
      cp activator-1.3.7-minimal/activator.bat TrainerPlus
      ```

  2.  Move to TrainerPlus directory, run the project by executing `activator universal:packageZipTarball`

      ```
      cd TrainerPlus
      ./activator universal:packageZipTarball
      ```

      It should create file `target/universal/trainer-2.5.1.tgz` (name is depends on `build.sbt`)

  3.  Extract and run the created app by

      ```
      tar xf target/universal/trainer-2.5.1.tgz
      target/universal/trainer-2.5.1/bin/trainer
      ```
