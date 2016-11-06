(defproject chatter "0.1.0-SNAPSHOT"  
  :description "Clojure web app for displaying messages"  
  :url "https://github.com/AustinClojure/workshop"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]                 
                 [ring/ring-jetty-adapter "1.5.0"]                 
                 [ring/ring-defaults "0.2.1"]
                 [hickory "0.5.4"]                 
                 [environ "1.0.0"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.9.7"]            
            [lein-environ "1.0.0"]]
  :ring {:handler chatter.handler/app}
  :profiles {
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]                               
                                  [ring/ring-mock "0.3.0"]
                                  [kerodon "0.8.0"]]}

             :production {:ring {:open-browser? false
                                 :stacktraces? false
                                 :auto-reload? false}
                          :env {production true}}}
  :aot :all  
  :main chatter.main  
  :uberjar-name "chatter-standalone.jar")
