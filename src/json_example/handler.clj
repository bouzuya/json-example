(ns json-example.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clj-json.core :as json])
  (:import [org.joda.time DateTime]
           [org.joda.time.format ISODateTimeFormat]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/json" [] (json/generate-string
                    {:message "Hello World"
                     :created_at (->
                                   (ISODateTimeFormat/dateTime)
                                   (.print (DateTime.)))}))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
