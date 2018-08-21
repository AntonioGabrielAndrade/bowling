(defproject bowling "0.1.0-SNAPSHOT"
  :description "Clojure Bowling Kata"
  :url "https://github.com/AntonioGabrielAndrade/bowling"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot bowling.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
