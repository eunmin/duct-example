(ns duct-example.boundary.user-db
  (:require [duct.database.redis.carmine]
            [taoensso.carmine :as car :refer [get]]))

(defprotocol UserDatabase
  (get-user [db username]))

(extend-protocol UserDatabase
  duct.database.redis.carmine.Boundary
  (get-user [db username]
    (car/wcar (:conn-opts db)
              (car/get (str "user:" username)))))
