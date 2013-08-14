(ns webber.core
  (:require [immutant.web :as web]
            [immutant.messaging :as msg]
            [ring.util.response :refer :all]))

(defn app
  [req]
  (let [quote (msg/request "queue/quotes" {})
        quote-txt (deref quote 1000 "When you're out of slits, you're out of pier.")]
    (-> (response quote-txt)
        (content-type "text/html"))))

(defn start
  []
  (msg/start "queue/quotes")
  (web/start app))
