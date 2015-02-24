# https://github.com/tariqdaouda/pyArango
from pyArango.connection import Connection


def get_or_create_database(name):
    conn = Connection()
    if not conn.hasDatabase(name):
        conn.createDatabase(name=name)
    return conn[name]


def get_or_create_collection(db, name):
    if not db.hasCollection(name):
        db.createCollection(name=name)
    return db[name]


def create_documents(collection):
    for i in xrange(100):
        doc = collection.createDocument()
        doc["title"] = "How to -%d" % i
        doc["author"] = "Marcelo Cure"
        doc["year"] = 2015 + i
        doc.save()


def get_documents(db):
    aql = "FOR c IN books LIMIT 10 RETURN c"
    return db.AQLQuery(aql, rawResults=False, batchSize=10)


def main():
    db = get_or_create_database("library")
    collection = get_or_create_collection(db, "books")
    create_documents(collection)
    results = get_documents(db)
    for result in results:
        print result

if __name__ == '__main__':
    main()
