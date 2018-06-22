(ns duct-example.handler.example
  (:require [compojure.core :refer :all]
            [integrant.core :as ig]
            [duct-example.boundary.user-db :refer [get-user]]))

(defmethod ig/init-key :duct-example.handler/example [_ {:keys [redis]}]
  (context "/example" []
    (GET "/" []
      {:body {:example (get-user redis "username")}})))
