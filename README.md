# TrainerPlus

## Configuring the Database
  0.  First, you need to have MySQL installed, create the database named `trainer-plus` with an encoding set to `UTF-8`

  1.  At the root directory of the project(TrainerPlus), edit the file `conf/application.conf` 

  using the following command (in linux)
  ```
  vi conf/application.conf
  ```

  2.  Look for the `Database Configuration` section, you should see something like ..
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
  
