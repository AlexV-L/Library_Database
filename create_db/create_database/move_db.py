import os
import shutil

isVerbose = True

if isVerbose:
    print("Moving database...")
shutil.move("library_db.sqlite", "../library_db.sqlite")

if isVerbose:
    print("Moving database backup (if exists)...")
try:
    shutil.move("library_db_backup.sqlite", "../library_db_backup.sqlite")
except FileNotFoundError:
    if isVerbose:
        print("No backup found.")

if isVerbose:
    print("Finished! Feel free to delete /database/ now. Nothing more to do there.")