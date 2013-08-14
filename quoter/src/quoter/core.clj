(ns quoter.core
  (:require [immutant.messaging :as msg]
            [net.cgrand.enlive-html :as html]
            [clj-http.client :as client]))

(defonce mst3k-quote-cache
  (delay
   (let [uri "http://en.wikiquote.org/wiki/Mystery_Science_Theater_3000"
         page (client/get uri)
         content (:body page)]
     (-> content
         (html/html-snippet)
         (html/select [:dl])))))

(defn mst3k-quote
  [& [num]]
  (let [quotes @mst3k-quote-cache
        num (when (integer? num) num)
        which (or num (rand-int (count quotes)))]
    (apply str
           (-> quotes
               (nth which)
               (html/emit*)))))

(defn start
  []
  @mst3k-quote-cache
  (msg/start "queue/quotes")
  (msg/respond "queue/quotes" mst3k-quote))
