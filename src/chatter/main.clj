(ns chatter.main  
 (:require [chatter.handler :as chatter]            
           [environ.core :as env]      
           [ring.adapter.jetty :as jetty]))

(defn -main []
 (let [jetty-opts {:port
                   (Integer. (or (env/env :port) "3000"))
                   :join? false}]
   (jetty/run-jetty #'chatter/app jetty-opts)))
