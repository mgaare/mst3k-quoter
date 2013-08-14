(defproject webber "0.1.0-SNAPSHOT"
  :description "A web application for people who need interesting things to say from MST3K"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :immutant {:context-path "/"
             :nrepl-port 9001
             :init "webber.core/start"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-core "1.2.0"]])
