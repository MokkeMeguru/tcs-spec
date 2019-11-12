(defproject task-cabinet-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.fasterxml.jackson.core/jackson-core "2.10.0"] ;; required!!!
                 ;; for security
                 [buddy/buddy-hashers "1.4.0"]
                 ;; for json
                 [clj-time "0.15.2"]
                 [cheshire "5.9.0"]]
  :main ^:skip-aot task-cabinet-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-environ "1.1.0"]
            [cider/cider-nrepl "0.23.0-SNAPSHOT"]]
  :repl-options
  {:host "0.0.0.0"
   :port 39998})
