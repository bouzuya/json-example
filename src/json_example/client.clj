(ns json-example.client
  (:import [com.fasterxml.jackson.databind JsonNode ObjectMapper]
           [java.net URL]
           [java.io BufferedReader InputStreamReader]))

(defn get-json
  []
  (let [url (URL. "http://localhost:3000/json")
        conn (.openConnection url)
        code (.getResponseCode conn)]
    (when (= code 200)
      (let [reader (BufferedReader. (InputStreamReader. (.getInputStream conn)))]
        (try
          (let [builder (StringBuilder.)
                s (loop [line (.readLine reader)]
                    (if (nil? line)
                      (.toString builder)
                      (do
                        (.append builder line)
                        (recur (.readLine reader)))))]
            s)
          (finally (.close reader)))))))

(defn -main
  []
  (let [json (get-json)
        node (-> (ObjectMapper.) (.readTree json))]
    (println (str "message" ":" (-> node (.get "message") (.textValue))))
    (println (str "created_at" ":" (-> node (.get "created_at") (.textValue))))))

