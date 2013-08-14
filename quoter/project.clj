(defproject quoter "0.1.0-SNAPSHOT"
  :description "A datasource for fantastic quotes from MST3K"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :immutant {:nrepl-port 9002
             :init "quoter.core/start"}
  :dependencies [[clj-http "0.7.6"]
                 [enlive "1.1.1"]
                 [org.clojure/clojure "1.5.1"]])
